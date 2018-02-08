package sam09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sam09.model.Book;
import sam09.service.BookService;

public class Ex09 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("sam09/bean09.xml");

		BookService bs = (BookService) ac.getBean("service");
		/* ProductService ps = ac.getBean(ProductService.class); */
		Book book = bs.getBook();
		System.out.println(book); /* 메소드 실행 전/후
								   * 실행 메소드: getBook
								   * 매개변수: 고도를 기다리며
								   * around
								   * 메소드 실행 직후
								   * 메소드 실행 후, 정상 리턴된 후
								   * 실행 완료 후 리턴: getBook
								   * 실행 메소드의 아규먼트: 고도를 기다리며
								   * 도서 [제목: 고도를 기다리며, 가격: 20000]
								   */
	}

}
