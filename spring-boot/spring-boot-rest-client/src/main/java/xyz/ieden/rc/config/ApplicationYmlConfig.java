package xyz.ieden.rc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ThinkPad
 * @date Created by 2018/5/15 13:33
 */
@Configuration
@ConfigurationProperties(prefix = "m.rest.remote")
public class ApplicationYmlConfig {
    /**
     * 连接池的最大连接数默认为0
     */
    private int maxTotalConnect;
    /**
     * 单个主机的最大连接数
     */
    private int maxConnectPerRoute;
    /**
     * 连接超时默认2s
     */
    private int connectTimeout;
    /**
     * 读取超时默认30s
     */
    private int readTimeout;

    public int getMaxTotalConnect() {
        return maxTotalConnect;
    }

    public void setMaxTotalConnect(int maxTotalConnect) {
        this.maxTotalConnect = maxTotalConnect;
    }

    public int getMaxConnectPerRoute() {
        return maxConnectPerRoute;
    }

    public void setMaxConnectPerRoute(int maxConnectPerRoute) {
        this.maxConnectPerRoute = maxConnectPerRoute;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }
}
