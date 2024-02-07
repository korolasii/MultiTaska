package com.MultiTaska.MultiTaska;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCalc {

    @PostMapping("/calculate")
    public int calculate(@RequestBody String expression) {
        return 42;
    }
}

