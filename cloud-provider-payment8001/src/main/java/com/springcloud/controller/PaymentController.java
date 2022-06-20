package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String  serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult Create(@RequestBody Payment payment){




        int retcode=paymentService.create(payment);
        if(retcode==0){
             return  new CommonResult(0,"插入成功 端口号为："+serverPort);
        }else{
            return  new CommonResult(-1,"插入失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public DiscoveryClient getPaymentById(@PathVariable("id")  Long id ){

        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("***** element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;

//         Payment jpayment=paymentService.getPaymentById(id);
//        if(jpayment==null){
//            return  new CommonResult(-1,"插入成功");
//        }else{
//            return  new CommonResult(0,"查询成功 端口号为："+serverPort,jpayment);
//        }
    }


    @GetMapping(value = "/payment/lb/{id}")
    public String getPaymentlbById(@PathVariable("id")  Long id ){
        return  serverPort;
    }

}
