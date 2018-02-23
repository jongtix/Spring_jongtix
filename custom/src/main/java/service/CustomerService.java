package service;
import java.util.List;
import model.Customer;
public interface CustomerService {
	public List<Customer> findAll();
	public Customer findById(int id) throws Exception;
	public Customer register(Customer customer);
	public void update(Customer customer) throws Exception;
	public void delete(int id) throws Exception;
}