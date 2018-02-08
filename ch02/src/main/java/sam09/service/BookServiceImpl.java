package sam09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sam09.dao.BookDao;
import sam09.model.Book;

@Service("service")
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao dao;

	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@Override
	public Book getBook() {
		return dao.getBook("고도를 기다리며");
	}

}