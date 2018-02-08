package sam07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ps")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao pd;

	@Override
	public Product getProduct() {
		return pd.getProduct("망치");
	}

}
