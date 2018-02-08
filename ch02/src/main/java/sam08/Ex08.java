package sam08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex08 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("sam08/bean08.xml");

		BookService bs = (BookService) ac.getBean("bs");
		/* ProductService ps = ac.getBean(ProductService.class); */
		Book book = bs.getBook();
		System.out.println(book); /* 작업 전 around: execution(Book sam08.BookDao.getBook(String))
								   * 작업 전: getBook
								   * 작업 종료 후
								   * 작업 후 after returning: getBook
								   * 인수: 고도를 기다리며
								   * 도서 [제목: 고도를 기다리며, 가격: 20000]
								   */	
		}

}
