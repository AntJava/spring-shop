package com.geekbrains.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Around("@annotation(log)")
    protected Object logAround(ProceedingJoinPoint p, Log log) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Starting save order");
        Object proceed = p.proceed();

        long stop = System.currentTimeMillis() - start;
        System.out.format("Order saved in %s ms \n", stop);
        return proceed;
    }
}
