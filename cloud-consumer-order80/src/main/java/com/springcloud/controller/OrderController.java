package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private final  String url="http://cloud-payment-service";

    @PostMapping(value = "conturms/payment/create")
    public CommonResult Create(Payment payment){
        return  restTemplate.postForObject(url+"/payment/create",payment ,CommonResult.class);
    }

    @GetMapping(value = "conturms/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")  Long id ){
        return  restTemplate.getForObject(url+"/payment/get/"+id,CommonResult.class);
    }
}
