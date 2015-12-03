package com.kilo.driver;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

	private static Logger LOG = Logger.getLogger(LoggingAspect.class);

	@Around("execution(* set*(..)) && target(com.kilo.driver.FiboObject)")
	public Object performLogging(ProceedingJoinPoint pjp) throws Throwable {
		LOG.info(Arrays.toString(Thread.currentThread().getStackTrace()));
		return pjp.proceed();
	}
}
