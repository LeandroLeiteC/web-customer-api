package com.qintess.webapi.service;

import java.util.List;

import com.qintess.webapi.entity.Customer;


public interface CustomerService {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(int id);
	
	public void salvarOuAlterar(Customer customer);
	
	public void deletar(int id);
	
	public List<Customer> searchByName(String firstname);
}
