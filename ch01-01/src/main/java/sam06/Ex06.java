package sam06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex06 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("sam06/bean06.xml"); // 같은 패키지 내에 있을 때

		MessageBean mb = (MessageBean) ac.getBean("mb6");
		mb.sayHello(); // 홍길동님 안녕~!
	}
}
