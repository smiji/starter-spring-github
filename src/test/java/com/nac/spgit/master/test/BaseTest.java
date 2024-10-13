package com.nac.spgit.master.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@SpringBootTest(classes = {SpringBootTestStarter.class})
public interface BaseTest {
    default String readJsonFromFile(String fileLocationAfterTestResourceFolder) {
        File jsonFile = null;
        try {
            jsonFile = new ClassPathResource(fileLocationAfterTestResourceFolder).getFile();
            return new String(Files.readAllBytes(jsonFile.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    default <T> T deserialize(ObjectMapper objectMapper, Class<T> t, String sampleJsonData) {
        try {
            return objectMapper.readValue(sampleJsonData, t);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
