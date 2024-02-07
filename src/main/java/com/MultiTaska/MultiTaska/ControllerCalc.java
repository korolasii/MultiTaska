package com.MultiTaska.MultiTaska;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerCalc {

    @GetMapping("/calc")
    public String calc() {
        return "calc";
    }

}
