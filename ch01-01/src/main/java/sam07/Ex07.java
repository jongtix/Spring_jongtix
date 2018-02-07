package sam07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex07 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:bean07.xml"); // resources에 있을 때

		Vehicle vh = (Vehicle) ac.getBean("mb7");
		vh.ride(); // 임꺽정은 비행기을 1000km/h속도로 운행한다.
	}

}
