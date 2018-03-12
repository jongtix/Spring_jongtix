package ioc.injection;

import java.util.Iterator;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext ctx
		 = new GenericXmlApplicationContext("applicationContext.xml");
		PropertyBean pb = (PropertyBean)ctx.getBean("propertyBean");
		
		Map<Object, Object> address = pb.getAddress();
		Iterator<Object> keySet = address.keySet().iterator();
		
		while(keySet.hasNext()) {
			String name = (String)keySet.next();
			String addr = (String)address.get(name);
			System.out.println("이름-"+name+" 주소-"+addr);
		}
	}
}
