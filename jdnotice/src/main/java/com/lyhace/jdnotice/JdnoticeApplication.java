package com.lyhace.jdnotice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// 打开OpenFeign，自带Ribbon负载均衡功能
@EnableFeignClients
// 打开Hystrix
@EnableCircuitBreaker
public class JdnoticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdnoticeApplication.class, args);
    }

}
