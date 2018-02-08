package sam06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class ProductAdvice {

	public void before(JoinPoint jp) {
		Signature name = jp.getSignature();
		System.out.println("작업 전: " + name.getName());
	}

	public void after() {
		System.out.println("작업 종료 후");
	}

	public void afterReturning(JoinPoint jp, Product pt) {
		Signature name = jp.getSignature();
		System.out.println("작업 후 after returning: " + name.getName());
		Object[] obj = jp.getArgs();
		System.out.println("인수: " + obj[0]);
	}

	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		String name = pjp.getStaticPart().toString();
		System.out.println("작업 전 around: " + name);
		Object obj = pjp.proceed();
		return obj;
	}

	public void afterThrow(Throwable e) {
		System.out.println("에러 발생: " + e.getMessage());
	}

}
