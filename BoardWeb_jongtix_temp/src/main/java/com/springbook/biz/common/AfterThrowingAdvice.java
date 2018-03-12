package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {

	@AfterThrowing(pointcut = "PointcutCommon.allPointcut()", throwing = "exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();

		System.out.println(method + "() 메소드 수행 중 예외 발생");

		System.out.println("부적합한 값이 입력되었습니다.");
	}

}
