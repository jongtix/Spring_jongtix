package sam11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sam11.model.Book;
import sam11.service.BookService;

public class Ex11 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("sam11/bean11.xml");

		BookService bs = (BookService) ac.getBean("bs");
		Book bk = bs.getBook();
		System.out.println(bk); // 도서 [제목: 고도를 기다리며, 가격: 20000]
	}

}
