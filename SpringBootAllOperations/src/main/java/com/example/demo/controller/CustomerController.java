package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService ;
	
	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomerDetails(@RequestBody Customer cust ){
		
		Customer customer= customerService.saveCustomerDetails(cust);
		
		return ResponseEntity.ok().body(customer);
		
	}
	@PostMapping("/saveAll")
	public ResponseEntity<Iterable<Customer>> saveAllCustomer(@RequestBody Iterable<Customer> custList){
		
		Iterable<Customer> customerList = customerService.saveAllCustomer(custList);
		return ResponseEntity.ok().body(customerList);
		 
		
	}
	
	@DeleteMapping("/delete/{id}")
	void deleteCustomerById(@PathVariable("id") int id){
		
		customerService.deleteCustomerById(id);
		
	}
	
	@DeleteMapping("/delete")
	void deleteCustomer(@RequestBody Customer cust){
		
		customerService.deleteCustomer(cust);
		
	}
	
	@DeleteMapping("/deleteAll")
	void deleteAllCustomers(){
		
		customerService.deleteAllCustomers();
		
	}
	
	
	@GetMapping("/get/{id}")
	public Optional<Customer> findCustomerById(@PathVariable int id) {
		return customerService.findCustomerById(id);
	}
	
	@GetMapping("/getAll")
	public Optional<Iterable<Customer> >findAllCustomers() {
		return Optional.ofNullable(customerService.findAllCustomers());
	}
	
	@GetMapping("/getCustomerByCity/{city}")
	public List<Customer>  getAllCustomerByCity(@PathVariable String city) {
		return (List<Customer>) customerService.getAllCustomerByCity(city);
	}
	
	///getCustomer?city=Delhi&name=Nayra  https://localhost:8082/customer/get/5

	@GetMapping(value = "/getCustomerByCityName", params ={"city","name"})
	public List<Customer>  getAllCustomerByCityAndName(@RequestParam String city,@RequestParam String name) {
		return (List<Customer>) customerService.getAllCustomerByCityAndName(city,name);
	}
	}

