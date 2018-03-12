package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//POJO객체
@Service
@Aspect
public class AfterAdvice {
	//외부pointcut(PointcutCommon객체) 참조를 위해 주석처리
	/*@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
    public void allPointcut() {}*/

	//@After("allPointcut()")
	@After("PointcutCommon.allPointcut()")
	public void finallyLog() {
		System.out.println("[After 사후 처리]비즈니스 로직 수행 후 무조건 동작");
	}
}
