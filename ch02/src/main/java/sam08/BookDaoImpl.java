package sam08;

import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	@Override
	public Book getBook(String title) {
		return new Book(title, 20000);
	}

}
