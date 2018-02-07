package sam10;

public class ProductDaoImpl implements ProductDao {

	@Override
	public Product getProduct(String name) {
		return new Product(name, 2000);
	}

}
