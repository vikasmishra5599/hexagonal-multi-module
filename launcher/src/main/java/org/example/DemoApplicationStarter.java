package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages = {"org.example"})
//@EnableJpaRepositories(basePackages = {"com.example.service.db"})
@EntityScan("org.example.db.entity")
public class DemoApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationStarter.class, args);
    }
}
