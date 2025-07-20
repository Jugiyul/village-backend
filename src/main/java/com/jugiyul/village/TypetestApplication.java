package com.jugiyul.village;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(dateTimeProviderRef = "offsetDateTimeProvider")
public class TypetestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TypetestApplication.class, args);
    }
}