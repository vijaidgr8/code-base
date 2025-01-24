package com.cappack13.controller;

import javax.validation.Valid;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cappack13.dao.BarberDaoForCustomer;
import com.cappack13.model.Users;

@RestController
public class BarberControllerByNew {
	
	@Autowired
	BarberDaoForCustomer barDaoCus;
	
	
	Logger log=org.slf4j.LoggerFactory.getLogger(BarberControllerByAdmin.class);
	@PostMapping(path="/createCustomerbyAdmin")
	public Users addCustomer(@RequestBody Users user) {
		Users u = barDaoCus.addCustomer(user);
		if(u!=null)
		{
			log.info("Customer object created");
		}
		else
		{
			log.error("sorry not able to create Customer object");
		}
		return u;
	}
}
