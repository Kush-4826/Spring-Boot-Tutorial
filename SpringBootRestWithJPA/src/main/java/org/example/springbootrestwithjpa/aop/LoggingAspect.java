package org.example.springbootrestwithjpa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before(value = "execution(* org.example.springbootrestwithjpa.service.JobService.*(..))")
    public void call(JoinPoint jp) {
        LOGGER.info("Call AOP ... from " + jp.getSignature().getName());
    }
}
