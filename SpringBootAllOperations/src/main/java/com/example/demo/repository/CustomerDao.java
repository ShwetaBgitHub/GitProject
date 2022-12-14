package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {
	
	@Query(value = "select * from customer where customer_city=?1", nativeQuery = true)
	public List<Customer> getAllCustomerByCity(String city);
	
	@Query(value ="select * from customer where customer_city=?1 and customer_name=?2", nativeQuery =true)
	public List<Customer> getAllCustomerByCityAndName(String city, String name);

}
