package sam07;

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
public class ProductAdvice {

	@Before("execution(* getProduct(String))")
	public void before(JoinPoint jp) {
		Signature name = jp.getSignature();
		System.out.println("작업 전: " + name.getName());
	}

	@After("execution(* getProduct(String))")
	public void after() {
		System.out.println("작업 종료 후");
	}

	@AfterReturning(value="execution(* getProduct(String))", returning="pt")
	public void afterReturning(JoinPoint jp, Product pt) {
		Signature name = jp.getSignature();
		System.out.println("작업 후 after returning: " + name.getName());
		Object[] obj = jp.getArgs();
		System.out.println("인수: " + obj[0]);
	}

	@Around("execution(* getProduct(String))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		String name = pjp.getStaticPart().toString();
		System.out.println("작업 전 around: " + name);
		Object obj = pjp.proceed();
		return obj;
	}

	@AfterThrowing(value="execution(* getProduct(String))", throwing="e")
	public void afterThrow(Throwable e) {
		System.out.println("에러 발생: " + e.getMessage());
	}

}
