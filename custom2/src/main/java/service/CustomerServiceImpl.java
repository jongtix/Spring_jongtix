package service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import model.Customer;

@Service("cs") // autoWired
public class CustomerServiceImpl implements CustomerService {
	private Map<Integer, Customer> customerMap = new LinkedHashMap<>();
	private int nextId = 1;

	@PostConstruct // 생성직후 초기화 작업 annotation
	public void initCustomer() {
		nextId = 1;
		register(new Customer("길동", "서울시 강남구", "kildong@aa.bb.cc"));
		register(new Customer("꺽정", "서울시 강서구", "kk@aa.dd.bb"));
		register(new Customer("지매", "서울시 강동구", "ii@gg.dd.bb"));
	}

	@Override
	public List<Customer> findAll() {
		return new ArrayList<Customer>(customerMap.values());
	}

	@Override
	public Customer findById(int id) throws Exception {
		return null;
	}

	@Override
	public Customer register(Customer customer) {
		customer.setId(nextId++);
		customerMap.put(customer.getId(), customer);
		return null;
	}

	@Override
	public boolean isFreeEmailCustomer(Customer customer) {
		return false;
	}

}
