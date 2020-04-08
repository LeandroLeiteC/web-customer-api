package com.qintess.webapi.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.qintess.webapi.entity.Customer;


@Repository
public class CustomerDao {

	@PersistenceContext
	EntityManager em;
	
	public List<Customer> getByFirstNameDAO(String name){
		
		// first name results
		String jpql = "SELECT c FROM Customer c WHERE lower(c.firstName) like :name";
	    TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
	    query.setParameter("firstName", "%"+name.toLowerCase()+"%");
	    
	    // last name results
	    String jpql2 = "SELECT c FROM Customer c WHERE lower(c.lastName) like :name";
	    TypedQuery<Customer> query2 = em.createQuery(jpql2, Customer.class);
	    query2.setParameter("firstName", "%"+name.toLowerCase()+"%");
	    
	    Set<Customer> customers = new HashSet<Customer>();
	    customers.addAll(query.getResultList());
	    customers.addAll(query2.getResultList());
	    
	    List<Customer> lista = new ArrayList<Customer>();
	    lista.addAll(customers);
	    
	    return lista;
		
	}
}
