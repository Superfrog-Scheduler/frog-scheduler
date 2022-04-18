package webtech.frogscheduler.frogschedulerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import webtech.frogscheduler.frogschedulerbackend.utils.IdWorker;

@SpringBootApplication
public class FrogSchedulerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrogSchedulerBackendApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}
