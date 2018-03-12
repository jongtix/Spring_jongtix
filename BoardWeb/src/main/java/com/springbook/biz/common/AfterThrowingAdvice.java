package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//POJO객체
@Service
@Aspect
public class AfterThrowingAdvice {
	//외부pointcut(PointcutCommon객체) 참조를 위해 주석처리
   /* @Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
    public void allPointcut() {}*/
    //실행메소드 정보를 얻기위한 객체 JoinPoint객체,예외정보얻기위한 예외객체exceptObj
    //throws Exception()으로 예외가 넘어왔을 때 처리
    //@AfterThrowing(pointcut="allPointcut()", throwing="exceptObj")
    @AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		System.out.println("[AfterThrowing 예외 처리]비즈니스 로직 중 예외 발생");
		String method = jp.getSignature().getName();
        System.out.println(method + "() 메소드 수행 중 예외 발생!");
        if(exceptObj instanceof Exception) {
                System.out.println("부적합한 값이 입력되었습니다.");
        } 
	}
}
