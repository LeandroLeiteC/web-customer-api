package com.qintess.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qintess.webapi.dao.CustomerDao;
import com.qintess.webapi.dao.GenericDao;
import com.qintess.webapi.entity.Customer;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	GenericDao<Customer> customerDao;

	@Autowired
	CustomerDao cusDao;

	@Override
	public List<Customer> getCustomers() {
		return customerDao.buscarTodosDAO(Customer.class);
	}

	@Override
	public void salvarOuAlterar(Customer customer) {
		customerDao.salvarOuAlterarDAO(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		return customerDao.buscarPorIdDAO(Customer.class, id);
	}

	@Override
	public void deletar(int id) {
		customerDao.deletarDAO(Customer.class, id);
	}

	@Override
	public List<Customer> searchByName(String firstname) {
		return cusDao.getByFirstNameDAO(firstname);
	}


}
