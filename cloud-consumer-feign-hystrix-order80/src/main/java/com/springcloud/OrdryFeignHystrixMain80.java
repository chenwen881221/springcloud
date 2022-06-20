package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableHystrix
@EnableFeignClients
public class OrdryFeignHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrdryFeignHystrixMain80.class,args);
    }
}
