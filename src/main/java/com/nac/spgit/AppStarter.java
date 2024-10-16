package com.nac.spgit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Mention the @Spring boot annotation
@SpringBootApplication
@EntityScan(basePackages = {"com.nac.spgit.entities"})
@EnableJpaRepositories(basePackages = {"com.nac.spgit.repo"})
@ComponentScan(basePackages = {"com.nac.spgit"})
public class AppStarter {
    public static void main(String[] args) {
        // Let the spring container know your application
        SpringApplication.run(AppStarter.class, args);
    }
}