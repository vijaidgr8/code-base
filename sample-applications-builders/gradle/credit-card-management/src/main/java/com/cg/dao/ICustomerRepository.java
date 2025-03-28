package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bean.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

	// Get customer by userId
	public Customer findCustomerByUserId(String userId);
}
