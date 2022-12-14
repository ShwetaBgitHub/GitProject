package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Customer;

public interface CustomerService {

	public Customer saveCustomerDetails(Customer cust);
	
	public Iterable<Customer> saveAllCustomer(Iterable<Customer> customerList);
	
	
	
	
	
	//Delete
	public void deleteCustomerById(int id);
	
	public void deleteCustomer(Customer cust); // not working
	
	void deleteAllCustomers();
	
	
	// get
	
	Optional<Customer> findCustomerById(int id);
	
	Iterable<Customer> findAllCustomers();
	
	List<Customer> getAllCustomerByCity(String city);
	
	List<Customer> getAllCustomerByCityAndName(String city,String name);

}
