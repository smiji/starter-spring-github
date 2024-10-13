package com.nac.spgit.master.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.nac.spgit.entities"})
@EnableJpaRepositories(basePackages = {"com.nac.spgit.repo"})
public class SpringBootTestStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestStarter.class, args);
    }

}
