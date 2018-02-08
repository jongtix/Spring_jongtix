package sam05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex05_3 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("sam05/bean05_3.xml");

		Vehicle vh = ac.getBean(Vehicle.class); // AOP Annotation을 이용한 bean 정보 얻기
		vh.ride(); /* 메소드 시작, 메소드명: method-execution
					* 이순신(이)가 거북선을(를) 운행한다.
					* 메소드 종료, 소요시간: 3.0s
					*/
	}

}
