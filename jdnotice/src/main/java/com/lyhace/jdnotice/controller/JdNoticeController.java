package com.lyhace.jdnotice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyhace.jdnotice.service.DoingCommOpenfeignService;
import com.lyhace.jdnotice.service.DoingOpenfeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/JD")
@Slf4j
public class JdNoticeController {

//    @Qualifier("doingHystrixService")
//    @Autowired
    @Resource
    private DoingOpenfeignService doingOpenfeignService;
    @Resource
    private DoingCommOpenfeignService doingCommOpenfeignService;

    @GetMapping("/notice")
    public String notice(@RequestBody String json){

        ObjectMapper objectMapper = new ObjectMapper();
        Map maps = null;
        String mes = "";
        try {
            maps = objectMapper.readValue(json, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if(maps != null && maps.get("type") != null && maps.get("type").equals("common")){
            mes =  doingCommOpenfeignService.doing();
        }else{
            mes =  doingOpenfeignService.doing();
        }

        log.info("服务调用完成：{}", mes);

        return mes;
    }
}
