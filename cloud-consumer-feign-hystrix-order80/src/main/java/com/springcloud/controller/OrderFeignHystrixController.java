package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFeignHystrixController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String getPaymentById(@PathVariable("id") Integer id){
        return orderService.paymentInfo_OK(id);
    }


    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        return orderService.paymentInfo_TimeOut(id);
    }
}
