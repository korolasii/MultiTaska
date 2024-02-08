package com.MultiTaska.MultiTaska;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerWeather {
    @GetMapping("/weather1")
    public String weather1(){return "weather1";}
}
