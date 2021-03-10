package com.lyhace.jdnotice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "jddoing", fallback = DoingHystrixService.class)
public interface DoingOpenfeignService {

    @RequestMapping("/JD/doing")
    public String doing();
}
