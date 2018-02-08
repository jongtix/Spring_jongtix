package sam09.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {

	@Before("execution(* getBook(String))")
	public void before(JoinPoint jp) {
		Signature name = jp.getSignature();
		String methodname = name.getName();
		System.out.println("실행 메소드: " + methodname);
		Object[] obj = jp.getArgs();
		System.out.println("매개변수: " + obj[0]);
	}

	@After("execution(* getBook(String))")
	public void after() {
		System.out.println("메소드 실행 직후");
	}

	@AfterReturning(value = "execution(* getBook(String))")
	public void afterReturning(JoinPoint jp) {
		System.out.println("메소드 실행 후, 정상 리턴된 후");
		Signature name = jp.getSignature();
		String methodname = name.getName();
		System.out.println("실행 완료 후 리턴: " + methodname);
		Object[] obj = jp.getArgs();
		System.out.println("실행 메소드의 아규먼트: " + obj[0]);
	}

	@Around("execution(* getBook(String))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("메소드 실행 전/후");
		Object rtnObj = pjp.proceed();
		System.out.println("around");
		return rtnObj;
	}

	@AfterThrowing(value = "execution(* getBook(String))", throwing = "e")
	public void afterThrowing(Throwable e) {
		System.out.println("예외 발생: " + e.getMessage());
	}
}
