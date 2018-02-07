package sam05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex05 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean05.xml"); // java폴더에 있을 때

		MessageBean mb = (MessageBean) ac.getBean("mb5");
		mb.sayHello(); // 길동님 안녕하세요
	}
}
