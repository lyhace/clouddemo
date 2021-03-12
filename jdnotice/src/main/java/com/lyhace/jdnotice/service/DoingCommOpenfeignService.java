package com.lyhace.jdnotice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "jddoing", fallback = DoingHystrixService.class)
@FeignClient(name = "commdoing", fallbackFactory = DoingCommHystrixFactory.class)
public interface DoingCommOpenfeignService {

    @RequestMapping(value = "/COMM/doing", method = RequestMethod.POST)
    public String doing();
}
