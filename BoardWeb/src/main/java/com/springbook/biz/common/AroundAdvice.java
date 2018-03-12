package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

//POJO객체
@Service
@Aspect
public class AroundAdvice {
	//Advice가 적용되는 지점(메소드)
	//외부pointcut(PointcutCommon객체) 참조를 위해 주석처리
	/*@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
    public void allPointcut(){}*/
	//@Around("allPointcut()")//Advice
	@Around("PointcutCommon.allPointcut()")//Advice
	//AroundAdvice가 메소드를 간접 실행시키기 위해 ProceedingJoinPoint를 매개변수로 받고
	//매개변수로 받은 ProceedingJoinPoint의 proceed()메소드로 간접 실행
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		String method = pjp.getSignature().getName(); 
		Object returnObj = pjp.proceed();
        System.out.println("[Around ]"+method + "() 메소드 수행에 걸린 시간 : " 
        + stopWatch.getTotalTimeMillis() + "(ms)초");

		return returnObj;
	}
}
