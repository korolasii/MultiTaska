package com.MultiTaska.MultiTaska;

import org.springframework.web.bind.annotation.GetMapping;

public class ControllerCalc {

    @GetMapping("/calc")
    public String calc() {
        return "calc";
    }
}
