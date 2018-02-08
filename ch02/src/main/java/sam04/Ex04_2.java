package sam04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex04_2 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("sam04/bean04_2.xml");

		MessageBean mb = (MessageBean) ac.getBean("mb");
		mb.sayHello();/* 메소드 시작, 메소드명: method-execution
		 			   * 길동님 안녕하세요~
					   * 메소드 종료, 소요시간: 3.0s
					   */
	}

}
