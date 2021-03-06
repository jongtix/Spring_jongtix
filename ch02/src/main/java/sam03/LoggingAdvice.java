package sam03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

// AOP로 적용할 Advice 정의
public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invoke) throws Throwable {
		String name = invoke.getMethod().getName();
		StopWatch sw = new StopWatch();
		sw.start(name); // name명의 메소드가 실행될 때 StopWatch 실행
		System.out.println("메소드 시작, 메소드명: " + name);
		Object obj = invoke.proceed(); // 메소드 실행 결과 리턴
		sw.stop();
		double total = sw.getTotalTimeMillis() / 1000;
		System.out.println("메소드 종료, 소요시간: " + total + "s");
		return obj;
	}

}
