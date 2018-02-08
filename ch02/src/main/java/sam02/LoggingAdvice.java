package sam02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invoke) throws Throwable {
		String name = invoke.getMethod().getName(); // 현재 실행중인 메소드의 이름을 저장
		StopWatch sw = new StopWatch();
		sw.start(name);
		System.out.println("log 시작, 메소드: " + name);
		Object obj = invoke.proceed(); // 메소드 실행 -- joinPoint
		sw.stop();
		double total = sw.getTotalTimeMillis() / 1000;
		System.out.println("log 종료, 전체 작업 시간: " + total + "s");
		return obj;
	}

}
