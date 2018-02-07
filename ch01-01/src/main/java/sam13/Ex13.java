package sam13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sam13.model.Book;
import sam13.service.BookService;

public class Ex13 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/sam13/bean13.xml");

		BookService bs = ac.getBean(BookService.class);
		Book bt = bs.getBook();
		System.out.println(bt); // 도서[제목: 고도를 기다리며, 가격: 20000]
	}

}
