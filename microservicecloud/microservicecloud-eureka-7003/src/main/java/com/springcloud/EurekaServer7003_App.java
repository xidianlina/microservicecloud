package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer7003_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003_App.class,args);
        System.out.println("EurekaServer Successful!!!");
    }
}