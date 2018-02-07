package sam11.dao;

import sam11.model.Book;

public class BookDaoImpl implements BookDao {

	@Override
	public Book getBook(String title) {
		return new Book(title, 20000);
	}

}
