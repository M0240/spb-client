package com.edu.spbclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.edu.signalAlgorithm")
@SpringBootApplication
public class SpbClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbClientApplication.class, args);
    }

}
