package com.tobilko;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(/*exclude = {SecurityAutoConfiguration.class}*/)
public class Runner {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Runner.class, args);
    }

}