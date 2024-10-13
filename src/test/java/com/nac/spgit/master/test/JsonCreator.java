package com.nac.spgit.master.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nac.spgit.beans.Structure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


public class JsonCreator {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createJsonString() {
        Structure structure = new Structure();
        structure.setDescription("3 bhk");
        structure.setId(1);
        try {
            String jsonString = objectMapper.writeValueAsString(structure);
            System.out.println(jsonString);
            Assertions.assertNotNull(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
