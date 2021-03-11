package com.lyhace.jdnotice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 打开OpenFeign，自带Ribbon负载均衡功能
@EnableFeignClients
@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class JdnoticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdnoticeApplication.class, args);
    }

}
