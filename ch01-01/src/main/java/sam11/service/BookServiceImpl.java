package sam11.service;

import sam11.dao.BookDao;
import sam11.model.Book;

public class BookServiceImpl implements BookService {
	private BookDao dao;

	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@Override
	public Book getBook() {
		return dao.getBook("고도를 기다리며");
	}

}