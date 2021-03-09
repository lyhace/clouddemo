package com.lyhace.jddoing.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/JD")
@Slf4j
public class JdDoingController {

    @GetMapping("/doing")
    public String doing(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String Mes = "JD doing ...";
        log.info(Mes);
        return Mes;
    }
}
