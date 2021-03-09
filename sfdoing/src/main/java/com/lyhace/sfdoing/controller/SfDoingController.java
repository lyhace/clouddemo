package com.lyhace.sfdoing.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SF")
@Slf4j
public class SfDoingController {

    @GetMapping("/doing")
    public String doing(){
        String Mes = "SF doing ...";
        log.info(Mes);
        return Mes;
    }
}
