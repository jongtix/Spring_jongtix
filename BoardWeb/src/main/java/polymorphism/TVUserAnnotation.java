package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserAnnotation {
	public static void main(String[] args) {
		//bean설정 정보를 읽어올 객체 생성
		AbstractApplicationContext factory
		 = new GenericXmlApplicationContext("annotationContext.xml");
		//getBean()메소드를 이용한 객체 대입
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		//메소드 다형성
	/*	tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();*/
		TV tv2 = (TV)factory.getBean("tv");
		TV tv3 = (TV)factory.getBean("tv");
		
		factory.close();//자원해제
		
	}
}
