package ioc.injection;

import java.util.Iterator;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MapBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext application
		 = new GenericXmlApplicationContext("applicationContext.xml");
		MapBean mapBean = (MapBean)application.getBean("mapBean");
		Map<String,String> map = mapBean.getAddress();
		Iterator<String> keySet = map.keySet().iterator();
		
		while(keySet.hasNext()) {
			String key = keySet.next();
			String address = map.get(key);
			System.out.println("이름:"+key+" 주소:"+address);
		}
	}
}
