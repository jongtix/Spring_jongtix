package com.team.project.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	@Pointcut("execution(* com.team.project..*Impl.*(..))")
	public void allPointcut() {
	}

	@Before("allPointcut()")
	public void printLog() {
		System.out.println("세션체크");
	}
}
