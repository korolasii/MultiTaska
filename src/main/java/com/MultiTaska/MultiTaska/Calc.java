package com.MultiTaska.MultiTaska;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Calc {

    @GetMapping("/calc")
    public String calc() {
        return "calc";
    }
}
