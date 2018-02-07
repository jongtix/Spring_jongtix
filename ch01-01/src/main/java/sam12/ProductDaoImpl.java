package sam12;

import org.springframework.stereotype.Component;

@Component
public class ProductDaoImpl implements ProductDao {

	@Override
	public Product getProduct(String name) {
		return new Product(name, 5000);
	}

}
