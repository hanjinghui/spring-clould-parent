package com.itcast.hjh.hjheurakeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HjhEurakeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HjhEurakeServerApplication.class, args);
    }

}
