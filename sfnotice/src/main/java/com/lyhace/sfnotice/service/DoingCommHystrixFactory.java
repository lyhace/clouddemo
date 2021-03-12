package com.lyhace.sfnotice.service;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DoingCommHystrixFactory implements FallbackFactory<DoingCommOpenfeignService> {
    @Override
    public DoingCommOpenfeignService create(Throwable throwable) {

        return new DoingCommOpenfeignService(){

            @Override
            public String doing() {

                String message = "访问comm doing service 异常，已降级！";
                log.info(message);
                log.error("ERROR:", throwable);
                return message;
            }
        };
    }
}
