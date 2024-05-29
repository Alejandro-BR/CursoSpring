package com.alejandro.curso.springboot.app.aop.springboot_aop.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.curso.springboot.app.aop.springboot_aop.services.GreetingService;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {

        return ResponseEntity.ok((Collections.singletonMap("greeting", greetingService.sayHello("\033[0;94mAlejandro\033[0m", "\033[0;94mHola que tal!\033[0m"))));
    }

    @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError() {

        return ResponseEntity.ok((Collections.singletonMap("greeting", greetingService.sayHelloError("\033[0;94mAlejandro\033[0m", "\033[0;94mHola que tal!\033[0m"))));
    }
}
