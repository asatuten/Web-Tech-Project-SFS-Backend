package edu.tcu.cs.superfrogbackend;

import edu.tcu.cs.superfrogbackend.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SuperfrogbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperfrogbackendApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}
