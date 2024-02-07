package com.MultiTaska.MultiTaska;

import ch.qos.logback.core.boolex.JaninoEventEvaluatorBase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCalc {


    @PostMapping("/calculate")
    public double calculate(@RequestBody String expression) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(expression);
        String expressionCalc = jsonNode.get("expression").asText();
        return Calculate.evaluateExpression(expressionCalc);
    }
}

