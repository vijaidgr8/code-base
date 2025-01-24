package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bean.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {

	// Get All Accounts for a cutomer
//	@Query(value = "SELECT a FROM Account a WHERE ?1 IN customers")
//	public List<Account> findAllAccountsById(Customer customer);
}
