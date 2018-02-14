package ioc.injection;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		PropertyBean bean = (PropertyBean) factory.getBean("propertyBean");
		Map<Object, Object> map = bean.getAddress();
		Set<Object> key = map.keySet();
		Iterator<Object> it = key.iterator();

		while (it.hasNext()) {
			String keyValue = (String) it.next();
			String value = (String) map.get(keyValue);
			System.out.println("이름: " + keyValue + ", 주소: " + value);
		}

		factory.close();
	}

}
