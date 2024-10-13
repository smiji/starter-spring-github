package com.nac.spgit.master.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nac.spgit.dao.StructureMasterDao;
import com.nac.spgit.dao.StructureMasterDaoImpl;
import com.nac.spgit.repo.master.StructureMasterRepo;
import com.nac.spgit.service.StructureMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootTestConfig {
    // Keep the configuration for
    // DB connections
    // Repository
    // Dao

    @Autowired
    private StructureMasterRepo structureMasterRepo;

    @Bean
    public StructureMasterDao structureMasterDao() {
        return new StructureMasterDaoImpl(structureMasterRepo);
    }

    @Bean
    public StructureMasterService structureMasterService(StructureMasterDao structureMasterDao) {
        return new StructureMasterService(structureMasterDao);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
