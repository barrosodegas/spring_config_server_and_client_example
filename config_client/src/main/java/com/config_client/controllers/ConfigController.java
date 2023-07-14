package com.config_client.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/")
public class ConfigController {

    @Value("${api.limit.login.attempt:0}")
    String limit;

    @GetMapping
    public String getValue() {
        if(this.limit.equals("5")) {
            return  "Sucesso";
        }
        return  "Falha: " + this.limit;
    }
}
