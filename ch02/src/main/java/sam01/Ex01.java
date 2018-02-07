package sam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("sam01/applicationContext.xml");

		MessageBean mb = (MessageBean) ac.getBean("msg");
		mb.sayHello();
	}

}
