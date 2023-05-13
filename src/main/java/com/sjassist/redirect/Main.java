package com.sjassist.redirect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// @ComponentScan(basePackages = {"com.sjassist.redirect"})
// @EnableAutoConfiguration
// @Configuration
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public String welcome(){
        return "Back-end service is currently running";
    }

}