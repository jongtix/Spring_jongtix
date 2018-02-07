package sam12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex12 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/sam12/bean12.xml");

		ProductService ps = ac.getBean(ProductService.class);
		Product pt = ps.getProduct();
		System.out.println(pt); // 제품 [이름: 망치, 가격: 5000]
	}

}
