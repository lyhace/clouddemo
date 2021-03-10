package com.lyhace.jdnotice.controller;

import com.lyhace.jdnotice.service.DoingOpenfeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/JD")
@Slf4j
public class JdNoticeController {

//    @Qualifier("doingHystrixService")
//    @Autowired
    @Resource
    private DoingOpenfeignService doingOpenfeignService;

    @GetMapping("/notice")
    public String notice(){
        String Mes = doingOpenfeignService.doing();
        log.info("服务调用完成：{}", Mes);
        return Mes;
    }
}
