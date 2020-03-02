package com.example.demo.Aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuthAspect {
    Logger logger = LoggerFactory.getLogger(AuthAspect.class);

    @Before("execution(* com.example.demo.Controller.*Controller.*(..))")
    public void CheckAuth(final JoinPoint joinPoint){
        Object[] obj = joinPoint.getArgs();
        HttpServletRequest request = null;
        String cmp = null;
        for(Object temp : obj) {
            if (temp instanceof HttpServletRequest){
                try {
                    request = (HttpServletRequest)temp;
                    cmp = request.getHeader("authChk");
                } catch (Exception e) {
                    logger.info("EXCEPTION");
                }
            }
        }
        if (cmp == null || cmp.equals("authChk") == false) {
            
        }
    }
}