package com.yjtm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangxiangyang 2018年9月28日 描述：这里也要用到@EnableDiscoveryClient，
 *         让服务使用eureka服务器， 实现服务注册和发现
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudHelloConsumerApplication {
	// @Bean 应用在方法上，用来将方法返回值设为为bean
	@Bean
	@LoadBalanced // @LoadBalanced实现负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHelloConsumerApplication.class, args);
	}
}
