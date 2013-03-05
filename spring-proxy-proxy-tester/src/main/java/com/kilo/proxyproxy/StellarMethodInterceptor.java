
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

    @Around("(execution(* com.kilo.proxyproxy.*.*(..)) || execution(* net.webservicex.*.*(..)) )")
    public void handleMethod(ProceedingJoinPoint pjp) throws Throwable {
        LOG.info("I encountered stellar method in "
                + pjp.getThis().getClass().getCanonicalName());
        pjp.proceed();
    }
}
