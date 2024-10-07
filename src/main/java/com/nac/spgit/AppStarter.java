package com.nac.spgit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Mention the @Spring boot annotation
@SpringBootApplication
public class AppStarter {
    public static void main(String[] args) {
        // Let the spring container know your application
        SpringApplication.run(AppStarter.class, args);
    }
}