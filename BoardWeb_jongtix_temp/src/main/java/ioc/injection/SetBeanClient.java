package ioc.injection;

import java.security.Key;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SetBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		SetBean bean = (SetBean) factory.getBean("setBean");
		Iterator<String> it = bean.getAddress().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		factory.close();
	}

}
