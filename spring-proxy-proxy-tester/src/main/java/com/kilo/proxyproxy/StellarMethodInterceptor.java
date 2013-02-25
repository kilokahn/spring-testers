
package com.kilo.proxyproxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class StellarMethodInterceptor {

    private static final Logger LOG = LoggerFactory
            .getLogger(StellarMethodInterceptor.class);

    @Around("@annotation(stellarMethod)")
    public void handleMethod(ProceedingJoinPoint pjp,
            StellarMethod stellarMethod) throws Throwable {
        LOG.info("I encountered stellar method in "
                + pjp.getThis().getClass().getCanonicalName());
        pjp.proceed();
    }
}
