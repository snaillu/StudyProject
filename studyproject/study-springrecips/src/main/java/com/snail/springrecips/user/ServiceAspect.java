package com.snail.springrecips.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAspect {
	private final static Log log = LogFactory.getLog(ServiceAspect.class);
	
	@Pointcut("execution(* com.snail.springrecips.user.service..*(..))")
	public void aspect(){}
	
	@Before("aspect()")
	public void before(JoinPoint joinPoint){
		log.info("before "+joinPoint);
	}
	
	@After("aspect()")
	public void after(JoinPoint joinPoint){
		log.info("after "+joinPoint);
	}
	
	@Around("aspect()")
	public void around(JoinPoint joinPoint){
		long start = System.currentTimeMillis();
		try{
			((ProceedingJoinPoint)joinPoint).proceed();
			long end = System.currentTimeMillis();
			
			log.info("around "+ joinPoint+" use time: "+(end - start)+" ms!");
		}catch(Throwable e){
			long end = System.currentTimeMillis();
			log.error("around "+joinPoint +" \tuse time: "+(end-start)+" ms! with exception: "+e.getMessage());
		}
	}
	
	@AfterReturning("aspect()")
	public void afterReturn(JoinPoint joinPoint){
		log.info("after return "+ joinPoint);
	}
	
	@AfterThrowing(pointcut="aspect()",throwing="e")
	public void afterThrowing(JoinPoint joinPoint,Exception e){
		log.info("afterThrow "+joinPoint +" \t"+e.getMessage());
	}
}
