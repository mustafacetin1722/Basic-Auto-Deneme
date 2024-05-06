package com.mustafa.security.basicautodeneme.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {

    @GetMapping
    private String helloWorldPrivate(){
        return "Hello World from private endpoint.";
    }
    @GetMapping({"/user"})
    private String helloWorldUser(){
        return "Hello World from user private endpoint.";
    }

    @GetMapping({"/admin"})
    private String helloWorldAdmin(){
        return "Hello World from admin private endpoint.";
    }
}
