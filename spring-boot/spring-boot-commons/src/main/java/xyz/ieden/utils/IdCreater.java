package xyz.ieden.utils;

/**
 * @author lianghongwei01
 * @date 2018/9/17 16:27
 */
public class IdCreater {
    private static final long idepoch = 1288834974657L;
    private static final long workerIdBits = 5L;
    private static final long datacenterIdBits = 8L;
    private static final long maxWorkerId = 31L;
    private static final long maxDatacenterId = 255L;
    private static final long sequenceBits = 9L;
    private static final long workerIdShift = 9L;
    private static final long datacenterIdShift = 14L;
    private static final long timestampLeftShift = 22L;
    private static final long sequenceMask = 511L;
    private static long lastTimestamp = -1L;
    private long sequence = 0L;
    private final long workerId;
    private final long datacenterId;

    public IdCreater(long workerId, long datacenterId) {
        if (workerId <= 31L && workerId >= 0L) {
            if (datacenterId <= 255L && datacenterId >= 0L) {
                this.workerId = workerId;
                this.datacenterId = datacenterId;
            } else {
                throw new IllegalArgumentException("datacenter Id can't be greater than 255 or less than 0");
            }
        } else {
            throw new IllegalArgumentException("worker Id can't be greater than 31 or less than 0");
        }
    }

    public IdCreater(long workerId) {
        System.out.println("++++++++++++++++++workerID:" + workerId + "++++++++++++++++++");
        if (workerId <= 31L && workerId >= 0L) {
            this.workerId = workerId;
            this.datacenterId = 0L;
        } else {
            throw new IllegalArgumentException("worker Id can't be greater than 31 or less than 0");
        }
    }

    public long nextId() {
        return this.nextId(false, 0L);
    }

    public long nextId(long busid) {
        return this.nextId(true, busid);
    }

    private synchronized long nextId(boolean isPadding, long busid) {
        long timestamp = this.timeGen();
        long paddingnum = this.datacenterId;
        if (isPadding) {
            paddingnum = busid;
        }

        if (timestamp < lastTimestamp) {
            try {
                throw new Exception("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
            } catch (Exception var10) {
                var10.printStackTrace();
            }
        }

        if (lastTimestamp == timestamp) {
            this.sequence = this.sequence + 1L & 511L;
            if (this.sequence == 0L) {
                timestamp = this.tilNextMillis(lastTimestamp);
            }
        } else {
            this.sequence = 0L;
        }

        lastTimestamp = timestamp;
        long nextId = timestamp - 1288834974657L << 22 | paddingnum << 14 | this.sequence << 9 | this.workerId;
        return nextId;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp;
        for(timestamp = this.timeGen(); timestamp <= lastTimestamp; timestamp = this.timeGen()) {
            ;
        }

        return timestamp;
    }

    /**
     * 获取系统时间
     *
     * @return
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }


    public static void main(String[] args) {
        IdCreater idCreater= new IdCreater(12);
        System.out.println(idCreater.nextId());
        System.out.println(idCreater.nextId());
        System.out.println(idCreater.nextId());
        System.out.println(idCreater.nextId());
        System.out.println(idCreater.nextId());
        System.out.println(idCreater.nextId());
    }
}
