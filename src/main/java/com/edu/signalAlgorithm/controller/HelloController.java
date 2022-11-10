package com.edu.signalAlgorithm.controller;

import com.edu.signalAlgorithm.domain.timeDomainFeatures;
import com.edu.signalAlgorithm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/say")
    public List<?> selectAlgorithm(String name){
        return helloService.selectAlgorithmCall(name);
        //return helloService.TDFService(name);
    }
}
