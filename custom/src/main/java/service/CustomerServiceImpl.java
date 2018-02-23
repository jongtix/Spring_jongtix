package service;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import model.Customer;
@Service("cs")
public class CustomerServiceImpl implements CustomerService {
	private Map<Integer, Customer> customerMap =
			new LinkedHashMap<Integer, Customer>();
	private int nextId;
	@PostConstruct 
	public void initCustomer() { 
		nextId = 1; 
		register(new Customer("자룡","강남구","jaryong@aa.bb.cc")); 
		register(new Customer("길동","강서구","kildong@aa.bb.cc")); 
		register(new Customer("철수","노원구","chulsoo@aa.bb.cc"));
	}
	public Customer register(Customer customer) {
		customer.setId(nextId++);
		customerMap.put(customer.getId(), customer);
		return customer;
	}
	private boolean isExists(int id) {
		   System.out.println("isExists");
			return customerMap.containsKey(id);
	}
	public List<Customer> findAll() {
		return new ArrayList<Customer>(customerMap.values());
	}
	public Customer findById(int id) throws Exception {
		if (!isExists(id)) {	throw new Exception();	}
		return customerMap.get(id);
	}
	public void update(Customer customer) throws Exception {
		if (!isExists(customer.getId())) {
			throw new Exception();
		}
		customerMap.put(customer.getId(),customer);
	}
	public void delete(int id) throws Exception {
		if (!isExists(id)) {
			throw new Exception();
		}
		customerMap.remove(id);
	}
}