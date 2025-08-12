package com.codeWithProject.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.codeWithProject")
@EnableJpaRepositories(basePackages = "com.codeWithProject.Repository")
@EntityScan(basePackages = "com.codeWithProject.Entity")
public class EmployeeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServerApplication.class, args);
        System.err.println("***Hello***");
    }
}
