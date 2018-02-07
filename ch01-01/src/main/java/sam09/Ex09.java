package sam09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex09 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("sam09/bean09.xml");

		Vehicle vh = (Vehicle) ac.getBean("mb9");
		vh.ride(); // 꺽정님 안녕~
	}
}
