package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//POJO객체
@Service
@Aspect//Aspect = Pointcut + Advice
public class LogAdvice {
   /* @Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void printLog() {
		System.out.println("[공통 로그]비즈니스 로직 수행전 동작");
    }
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
      public void getPointcut() {
		System.out.println("[공통 로그] 비즈니스 로직 get메소드 수행전 동작");
	}*/
	//외부pointcut(PointcutCommon객체) 참조를 위해 주석처리
/*	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut(){}*/
/*	@Before("allPointcut()")*/
	@Before("PointcutCommon.allPointcut()")
	public void printLog() {
		System.out.println("[LogAdvice 공통 로그]비즈니스 로직 수행전 동작");
    }
}
