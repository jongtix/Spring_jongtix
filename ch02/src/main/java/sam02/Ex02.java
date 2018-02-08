package sam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex02 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("sam02/bean02.xml");

		MessageBean mb = (MessageBean) ac.getBean("proxy");
		mb.sayHello(); /* log 시작, 메소드: sayHello
						* 홍길동님 안녕하세요.
						* log 종료, 전체 작업 시간: 5.0s
						*/

	}

}
