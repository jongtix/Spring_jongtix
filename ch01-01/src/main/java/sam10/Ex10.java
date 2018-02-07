package sam10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex10 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("sam10/bean10.xml");

		ProductService ps = (ProductService) ac.getBean("ps");
		Product pt = ps.getProduct();
		System.out.println(pt); // pt변수가 print()메소드의 매개변수로 넘어가면 toString()메소드가 자동호출
		/* System.out.println(pt.toString()); */
		// 제품 [이름: 호치뽀치, 가격: 2000]
	}

}
