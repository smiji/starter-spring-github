package com.nac.spgit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SMController {

    @GetMapping("/getAllsm")
    public List<String> getAllSM(){
        return List.of("1 BHK","2 BHK","3 BHK");
    }

    @GetMapping("/")
    public String getHello(){
        return "Hello Docker";
    }
}
