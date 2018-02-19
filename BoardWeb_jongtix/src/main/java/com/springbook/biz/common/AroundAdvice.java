package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {

	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		String method = pjp.getSignature().getName();
		Object returnObj = pjp.proceed();
		System.out.println("[Around] " + method + "() 메소드 수행에 걸린 시간: " + stopWatch.getTotalTimeMillis() + "(ms)초");
		return returnObj;
	}

}
