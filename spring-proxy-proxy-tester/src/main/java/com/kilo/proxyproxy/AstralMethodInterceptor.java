
package com.kilo.proxyproxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AstralMethodInterceptor {

    private static final Logger LOG = LoggerFactory
            .getLogger(AstralMethodInterceptor.class);

    @Around("@annotation(astralMethod)")
    public void handleMethod(ProceedingJoinPoint pjp, AstralMethod astralMethod)
            throws Throwable {
        LOG.info("I encountered astral method in "
                + pjp.getThis().getClass().getCanonicalName());
        pjp.proceed();
    }
}
