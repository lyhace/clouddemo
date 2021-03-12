package com.lyhace.sfnotice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "sfdoing", fallback = DoingHystrixService.class)
@FeignClient(name = "sfdoing", fallbackFactory = DoingHystrixFactory.class)
public interface DoingOpenfeignService {

    @RequestMapping(value = "/SF/doing", method = RequestMethod.POST)
    public String doing();
}
