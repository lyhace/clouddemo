package com.lyhace.jdnotice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "jddoing",fallback = DoingHystrixService.class)
public interface DoingOpenfeignService {

    @GetMapping("/JD/doing")
    public String doing();
}
