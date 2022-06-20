package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PaymenMaint8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymenMaint8002.class,args);
    }
}
