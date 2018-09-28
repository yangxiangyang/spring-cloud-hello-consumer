package com.yjtm.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    //这里注入的restTemplate就是在com.sam.ConsumerApp中通过@Bean配置的实例
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hello-consumer")
    public String helloConsumer() {
        //调用hello-service服务，注意这里用的是服务名，而不是具体的ip+port
        String forObject = restTemplate.getForObject("http://hello-service/hello", String.class);
        System.out.println("service return :"+forObject);
        System.out.println("调用用户......");
        return "hello consumer finish !!!";
    }
    @RequestMapping("/test-consumer")
    public String testConsumer() {
    	return "test consumer finish !!!";
    }
}