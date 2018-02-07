package sam10;

public class ProductServiceImpl implements ProductService {
	private ProductDao pdao;

	public void setPdao(ProductDao pdao) {
		this.pdao = pdao;
	}

	@Override
	public Product getProduct() {
		return pdao.getProduct("호치뽀치");
	}

}
