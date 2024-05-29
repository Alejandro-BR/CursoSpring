package com.alejandro.curso.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

    @Pointcut("execution(* com.alejandro.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingLoggerPointCut() {
    }

    @Pointcut("execution(* com.alejandro.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingFooLoggerPointCut() {
    }
}
