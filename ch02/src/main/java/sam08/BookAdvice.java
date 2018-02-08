package sam08;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BookAdvice {

	@Before("execution(* getBook(String))")
	public void before(JoinPoint jp) {
		Signature name = jp.getSignature();
		System.out.println("작업 전: " + name.getName());
	}

	@After("execution(* getBook(String))")
	public void after() {
		System.out.println("작업 종료 후");
	}

	@AfterReturning(value="execution(* getBook(String))", returning="book")
	public void afterReturning(JoinPoint jp, Book book) {
		Signature name = jp.getSignature();
		System.out.println("작업 후 after returning: " + name.getName());
		Object[] obj = jp.getArgs();
		System.out.println("인수: " + obj[0]);
	}

	@Around("execution(* getBook(String))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		String name = pjp.getStaticPart().toString();
		System.out.println("작업 전 around: " + name);
		Object obj = pjp.proceed();
		return obj;
	}

	@AfterThrowing(value="execution(* getBook(String))", throwing="e")
	public void afterThrow(Throwable e) {
		System.out.println("에러 발생: " + e.getMessage());
	}

}
