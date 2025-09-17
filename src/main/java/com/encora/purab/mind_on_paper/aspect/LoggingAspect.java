package com.encora.purab.mind_on_paper.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.encora.purab.mind_on_paper.service.*.*(..))")
    public void beforeServiceOperation(JoinPoint joinPoint){
        System.out.println("Method called: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut="execution(* com.encora.purab.mind_on_paper.service.*.*(..))",
            returning="result")
    public void afterServiceOperation(JoinPoint joinPoint, Object result) {
        System.out.println("Method finished: " + joinPoint.getSignature().getName()
                + " return=" + result);
    }
}
