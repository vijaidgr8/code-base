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

import com.cg.exception.InvalidCredentailsException;
import com.cg.service.IUserService;

@SpringBootTest
class TestLogin {

	@Autowired
	private IUserService userService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@DisplayName("Admin sign in with valid credentials")
	@Test
	final void testAdminSignIn() {

		assertEquals(new ResponseEntity<>("Admin Signed In", HttpStatus.OK), userService.signIn("admin1", "admin@1"));
	}

	@DisplayName("Admin sign in with Invalid credentials")
	@Test
	final void testAdminSignInWithInvalidCredentials() {

		assertThrows(InvalidCredentailsException.class, () -> userService.signIn("admin1", "admin@2"));

		assertThrows(InvalidCredentailsException.class, () -> userService.signIn("admin2", "admin@1"));

		assertThrows(InvalidCredentailsException.class, () -> userService.signIn("admin2", "admin@2"));
	}

	@DisplayName("Customer sign in with valid credentials")
	@Test
	final void testCustSignIn() {

		assertEquals(new ResponseEntity<>("Customer Signed In", HttpStatus.OK),
				userService.signIn("cust123", "cust@123"));
	}

	@DisplayName("Customer sign in with Invalid credentials")
	@Test
	final void testCustSignInWithInvalidCredentials() {

		assertThrows(InvalidCredentailsException.class, () -> userService.signIn("cust123", "cust@1234"));

		assertThrows(InvalidCredentailsException.class, () -> userService.signIn("cust1234", "cust@123"));

		assertThrows(InvalidCredentailsException.class, () -> userService.signIn("cust1234", "cust@1234"));
	}

}
