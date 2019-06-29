package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class CustomerController {
    @GetMapping
    public String handlermethod(){
        return "test";
    }
}
