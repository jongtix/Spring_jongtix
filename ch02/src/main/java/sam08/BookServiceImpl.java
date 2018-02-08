package sam08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bs")
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