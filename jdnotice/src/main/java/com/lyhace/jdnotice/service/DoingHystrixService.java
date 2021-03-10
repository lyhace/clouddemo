package com.lyhace.jdnotice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("doingHystrixService")
@Component
@Slf4j
public class DoingHystrixService implements DoingOpenfeignService{

    @Override
    public String doing() {
        String message = "访问doing service 异常，已熔断！";
        log.info(message);
        return message;
    }
}
