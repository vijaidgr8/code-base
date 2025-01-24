package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.Account;
import com.cg.dao.IAccountRepository;
import com.cg.dao.ICustomerRepository;
import com.cg.exception.AccountNotFoundException;
import com.cg.exception.CustomerNotFoundException;

@Service
public class IAccountService {

	@Autowired
	private IAccountRepository accRepo;

	@Autowired
	private ICustomerRepository custRepo;

	// Add account to customer
	public String addAccount(long id, Account account) {

		if (!custRepo.existsById(id)) {

			throw new CustomerNotFoundException(
					"Customer with id " + id + " doesn't exist. \nEnter a valid customer id.");
		}

//		Customer customer = custRepo.findById(id).get();

		accRepo.saveAndFlush(account);

		return "Account added successfully";
	}

	public String updateAccount(long id, Account account) {

		if (!accRepo.existsById(id)) {
			throw new AccountNotFoundException("Account Not Found");
		}

		Account a = accRepo.findById(id).get();

		a.setAccountName(account.getAccountName());
		a.setBalance(account.getBalance());
		a.setType(account.getType());

		accRepo.saveAndFlush(a);

		return "Updated Successfully";
	}

	// Get Account for customer
	public Account getAccount(long id, long accountNumber) {

		if (!custRepo.existsById(id)) {

			throw new CustomerNotFoundException(
					"Customer with id " + id + " doesn't exist. \nEnter a valid customer id.");
		}

		if (!accRepo.existsById(accountNumber)) {
			throw new AccountNotFoundException("Account not found");
		}

		return accRepo.findById(accountNumber).get();
	}

	public List<Account> getAllAccounts() {

		if (accRepo.findAll().isEmpty()) {
			throw new com.cg.exception.NoAccountsFoundException("No accounts exists!");
		}

		return accRepo.findAll();
	}

	public String removeAccount(long id) {
		if (!accRepo.existsById(id)) {
			throw new AccountNotFoundException("Account does'nt exists!");
		}
		accRepo.deleteById(id);

		return ("Account deleted successfully");
	}

}
