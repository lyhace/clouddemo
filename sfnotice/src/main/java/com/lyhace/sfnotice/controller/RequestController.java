package com.lyhace.sfnotice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SF/")
public class RequestController {

    @GetMapping("request")
    public String mvc() {
        return "";
    }
}
