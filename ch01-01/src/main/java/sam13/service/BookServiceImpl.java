package sam13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sam13.dao.BookDao;
import sam13.model.Book;

@Service // service레이어 기능을 하는 component
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bd;

	@Override
	public Book getBook() {
		return bd.getBook("고도를 기다리며");
	}

}
