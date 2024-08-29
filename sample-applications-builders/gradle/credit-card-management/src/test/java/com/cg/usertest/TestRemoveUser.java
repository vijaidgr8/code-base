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
import com.cg.exception.UserNotFoundException;
import com.cg.service.IUserService;

@SpringBootTest
class TestRemoveUser {

	@Autowired
	private IUserService userService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@DisplayName("Remove user with valid Id")
	@Test
	final void testRemoveAdmin() {

		User userToRemove = userService.getUserByUserId("admin4");

		assertEquals(new ResponseEntity<String>("User removed successfully", HttpStatus.OK),
				userService.removeUser(userToRemove.getId()));
	}

	@DisplayName("Remove user with Invalid Id")
	@Test
	final void testRemoveAdminWithIncId() {

		assertThrows(UserNotFoundException.class, () -> userService.removeUser(100));
	}

}
