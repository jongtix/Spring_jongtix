package service;

import java.util.List;

import model.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int id) throws Exception;

	public Customer register(Customer customer);

	public boolean isFreeEmailCustomer(Customer customer);

	public Customer editCustomer(Customer customer);

}
