package sam06;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Override
	public Product getProduct(String name) {
		return new Product(name, 30000);
	}

}
