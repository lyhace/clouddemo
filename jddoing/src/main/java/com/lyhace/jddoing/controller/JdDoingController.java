package com.lyhace.jddoing.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/JD")
@Slf4j
public class JdDoingController {

    AtomicInteger index = new AtomicInteger();

    @RequestMapping("/doing")
    public String doing(){
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String Mes = "JD doing ..." + index.incrementAndGet();
        log.info(Mes);
        return Mes;
    }
}
