package sam13.dao;

import org.springframework.stereotype.Repository;

import sam13.model.Book;

@Repository // 영속성 기능을 담당하는 component
public class BookDaoImpl implements BookDao {

	@Override
	public Book getBook(String title) {
		return new Book(title, 20000);
	}

}
