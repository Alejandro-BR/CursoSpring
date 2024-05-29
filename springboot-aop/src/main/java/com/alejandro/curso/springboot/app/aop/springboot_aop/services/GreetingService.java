package com.alejandro.curso.springboot.app.aop.springboot_aop.services;

public interface GreetingService {
    String sayHello(String person, String phrase);
    String sayHelloError(String person, String phrase);
}
