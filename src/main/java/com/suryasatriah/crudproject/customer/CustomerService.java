package com.suryasatriah.crudproject.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
    @Autowired
	CustomerRepository repo;

	public void save(Customer customer) {
		repo.save(customer);
	}

	public List<Customer> listCustomers() {
		return (List<Customer>) repo.findAll();
	}

	public Customer getCustomer(Long id) {
		return repo.findById(id).get();
	}

	public void deleteCustomer(long id) {
		repo.deleteById(id);
	}

	public List<Customer> search(String keyword) {
		return repo.search(keyword);
	}

}
