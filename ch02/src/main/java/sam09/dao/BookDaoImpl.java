package sam09.dao;

import org.springframework.stereotype.Repository;

import sam09.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Override
	public Book getBook(String title) {
		return new Book(title, 20000);
	}

}
