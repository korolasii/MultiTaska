package com.MultiTaska.MultiTaska;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerStart {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}