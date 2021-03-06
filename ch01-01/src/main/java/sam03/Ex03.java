package sam03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Ex03 {

	public static void main(String[] args) {
		ApplicationContext bf = new FileSystemXmlApplicationContext("bean01.xml"); // xml파일로부터 bean 정보 획득

		/*
		 * BeanFactory bean = new XmlBeanFactory(new FileSystemResource("bean01.xml"));
		 */

		MessageBean mb = (MessageBean) bf.getBean("mb");
		mb.sayHello("Spring"); // Spring, 안녕~
	}

}
