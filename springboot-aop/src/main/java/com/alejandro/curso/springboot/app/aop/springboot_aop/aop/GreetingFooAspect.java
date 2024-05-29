package com.alejandro.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class GreetingFooAspect {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Before("GreetingServicePointcuts.greetingFooLoggerPointCut()")
  public void loggerBefore(JoinPoint joinPoint) {

    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    logger.info("\033[0;94m" + "Antes: " + method + " invocado con los parametros " + args + "\033[0m");
  }
}
