package com.cg.usertest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exception.UserNotFoundException;
import com.cg.service.IUserService;

@SpringBootTest
class TestGetUser {

	@Autowired
	private IUserService userService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@DisplayName("Get user with valid Id")
	@Test
	final void testGetUserById() {

		assertNotNull(userService.getUserById(1));
		;
	}

	@DisplayName("Get user with invalid Id")
	@Test
	final void testGetUserByIdWithIncId() {

		assertThrows(UserNotFoundException.class, () -> userService.getUserById(100));
	}

	@DisplayName("Get user with valid userId")
	@Test
	final void testGetUserByUserId() {

		assertNotNull(userService.getUserByUserId("admin1"));
		;
	}

	@DisplayName("Get user with invalid userId")
	@Test
	final void testGetUserByUserIdWithIncUserId() {

		assertThrows(UserNotFoundException.class, () -> userService.getUserByUserId("xyz"));
	}

}
