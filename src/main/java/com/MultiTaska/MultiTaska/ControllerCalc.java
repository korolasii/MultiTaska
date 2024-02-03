package com.MultiTaska.MultiTaska;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerCalc {

    @GetMapping("/calc")
    public String calc() {
        return "calc";
    }
}
