package com.cg.usertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.bean.User;
import com.cg.exception.AccessDeniedException;
import com.cg.service.IUserService;

@SpringBootTest
class TestAddUser {

	@Autowired
	private IUserService userService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@DisplayName("Adding admin")
	@Test
	final void testAddAdmin() {

		assertEquals(new ResponseEntity<String>("User added Successfully", HttpStatus.CREATED),
				userService.addUser(new User("admin4", "admin@4", "ADMIN")));
	}

	@DisplayName("Adding Customer")
	@Test
	final void testAddCustomer() {

		assertThrows(AccessDeniedException.class, () -> userService.addUser(new User("cust1", "cust@1", "CUST")));
	}

}
