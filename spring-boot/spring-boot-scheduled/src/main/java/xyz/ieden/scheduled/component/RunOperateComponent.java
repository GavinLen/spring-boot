package xyz.ieden.scheduled.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Gavin
 * @date 2018.05.12
 */
@Component
public class RunOperateComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunOperateComponent.class);

    @Scheduled(cron="0 0/2 8-20 * * ?")
    public void executeFileDownLoadTask() {

        // 间隔2分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        LOGGER.info("定时任务1:"+current.getId()+ ",name:"+current.getName());
    }

    @Scheduled(cron="0 0/1 8-20 * * ?")
    public void executeUploadTask() {

        // 间隔1分钟,执行工单上传任务1
        Thread current = Thread.currentThread();
        LOGGER.info("定时任务2:"+current.getId() + ",name:"+current.getName());
    }

    @Scheduled(cron="0 0/3 5-23 * * ?")
    public void executeUploadBackTask() {

        // 间隔3分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        LOGGER.info("定时任务3:"+current.getId()+ ",name:"+current.getName());
    }

}
