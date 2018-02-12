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
		Customer customer = customerMap.get(id);
		return customer;
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

	@Override
	public Customer editCustomer(Customer customer) {
		Customer c = customerMap.get(customer.getId());
		c.setId(customer.getId());
		c.setName(customer.getName());
		c.setAddress(customer.getAddress());
		c.setEmail(customer.getEmail());
		customerMap.put(c.getId(), c);
		return c;
	}

	@Override
	public void update(Customer customer) throws Exception {
		customerMap.put(customer.getId(), customer);
	}

	@Override
	public void delete(int id) throws Exception {
		customerMap.remove(id);
	}

}
