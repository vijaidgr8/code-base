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

import com.cg.exception.UserNotFoundException;
import com.cg.service.IUserService;

@SpringBootTest
class TestChangePassword {

	@Autowired
	private IUserService userService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@DisplayName("Admin password change with valid Id")
	@Test
	final void testAdminChangePwd() {

		assertEquals(new ResponseEntity<String>("Password Changed Successfully", HttpStatus.OK),
				userService.changePassword(4, "admin@22"));

	}

	@DisplayName("Admin password change with invalid Id")
	@Test
	final void testAdminChangePwdWithIncId() {

		assertThrows(UserNotFoundException.class, () -> userService.changePassword(6, "admin@22"));

	}

	@DisplayName("Customer password change with valid Id")
	@Test
	final void testCustChangePwd() {

		assertEquals(new ResponseEntity<String>("Password Changed Successfully", HttpStatus.OK),
				userService.changePassword(1, "cust@3456"));

	}

	@DisplayName("Customer password change with invalid Id")
	@Test
	final void testCustChangePwdWithIncId() {

		assertThrows(UserNotFoundException.class, () -> userService.changePassword(6, "cust@22"));

	}

}
