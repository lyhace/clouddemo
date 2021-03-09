package com.lyhace.commdoing.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/COMM")
@Slf4j
public class CommDoingController {

    @GetMapping("/doing")
    public String doing(){
        String Mes = "COMM doing ...";
        log.info(Mes);
        return Mes;
    }
}
