package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerDao;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao ;

	@Override
	public Customer saveCustomerDetails(Customer cust) {
		return customerDao.save(cust);
	}

	@Override
	public Iterable<Customer> saveAllCustomer(Iterable<Customer> customerList) {
		
		return customerDao.saveAll(customerList);
	}

	@Override
	public void deleteCustomerById(int id) {
		if(customerDao.existsById(id))
		{
		customerDao.deleteById(id);
		System.out.println("Deleted Customer with id = "+id);}
		else
			System.out.println("Given Id is not present in Table");
	}

	@Override
	public void deleteCustomer(Customer cust) {
		customerDao.delete(cust);
		System.out.println("Deleted Customer with info >> "+cust.toString());
	}

	@Override
	public void deleteAllCustomers() {
		customerDao.deleteAll();
		System.out.println("All deleted");
	}

	@Override
	public Optional<Customer> findCustomerById(int id) {
		Optional<Customer> cust = customerDao.findById(id);
		return cust;
	}

	@Override
	public Iterable<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		Iterable<Customer> custList = customerDao.findAll();
		return custList;
	}

	@Override
	public List<Customer> getAllCustomerByCity(String city) {
		List<Customer> custList = customerDao.getAllCustomerByCity(city);
		return custList;
	}

	@Override
	public List<Customer> getAllCustomerByCityAndName(String city, String name) {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomerByCityAndName(city, name);
	}

}
