package com.lyhace.jdnotice.service;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DoingHystrixFactory implements FallbackFactory<DoingOpenfeignService> {
    @Override
    public DoingOpenfeignService create(Throwable throwable) {

        return new DoingOpenfeignService(){

            @Override
            public String doing() {

                String message = "访问doing service 异常，已降级！";
                log.info(message);
                log.error("ERROR:", throwable);
                return message;
            }
        };
    }
}
