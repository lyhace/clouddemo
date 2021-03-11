package com.lyhace.jdnotice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "jddoing", fallback = DoingHystrixService.class)
@FeignClient(name = "jddoing", fallbackFactory = DoingHystrixFactory.class)
public interface DoingOpenfeignService {

    @RequestMapping(value = "/JD/doing", method = RequestMethod.POST)
    public String doing();
}
