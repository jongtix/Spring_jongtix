package sam06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex06 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("sam06/bean06.xml");

		ProductService ps = (ProductService) ac.getBean("ps");
		/* ProductService ps = ac.getBean(ProductService.class); */
		Product pt = ps.getProduct();
		System.out.println(pt); /* 작업 전: getProduct
								 * 작업 전 around: execution(Product sam06.ProductDao.getProduct(String))
								 * 작업 종료 후
								 * 작업 후 after returning: getProduct
								 * 인수: 망치
								 * 제품명: 망치, 가격: 30000
								 */	
		}

}
