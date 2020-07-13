package com.itcast.hjh.hjheurakeclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HjhEurakeClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HjhEurakeClientApplication.class, args);
    }

}
