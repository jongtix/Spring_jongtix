package ioc.injection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MapBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		MapBean bean = (MapBean) factory.getBean("mapBean");
		Map<String, String> map = bean.getAddress();
		Set<String> key = map.keySet();
		Iterator<String> it = key.iterator();
		while (it.hasNext()) {
			String keyValue = it.next();
			String value = map.get(keyValue);
			System.out.println("이름: " + keyValue + ", 주소: " + value);
		}

		factory.close();
	}

}
