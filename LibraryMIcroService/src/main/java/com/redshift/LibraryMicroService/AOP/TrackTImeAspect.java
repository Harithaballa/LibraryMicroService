package com.redshift.LibraryMicroService.AOP;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackTImeAspect {
	
	//logger
	private static Logger logger=Logger.getLogger(TrackTImeAspect.class);
	@Around("@annotation(com.redshift.LibraryMicroService.AOP.TrackTime)")
	public Object track(ProceedingJoinPoint jp) throws Throwable
	{
		long startTime=System.currentTimeMillis();
		Object obj=jp.proceed();
		long endTime=System.currentTimeMillis();
		logger.info(jp.getSignature()+" took "+(endTime-startTime)+" milli sec to execute");
		return obj;
	}
	
	
	
	
}
