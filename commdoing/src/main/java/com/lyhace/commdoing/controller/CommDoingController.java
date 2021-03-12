package com.lyhace.commdoing.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/COMM")
@Slf4j
public class CommDoingController {

    AtomicInteger index = new AtomicInteger();

    @RequestMapping("/doing")
    public String doing(){
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String Mes = "COMM doing ..." + index.incrementAndGet();
        log.info(Mes);
        return Mes;
    }
}
