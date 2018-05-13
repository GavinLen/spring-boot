package xyz.ieden.scheduled;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Gavin
 * @date 2018.05.12
 */
@SpringBootApplication
public class ScheduledApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ScheduledApplication.class);
        springApplication.setBannerMode(Banner.Mode.CONSOLE);
        springApplication.run(args);
    }
}
