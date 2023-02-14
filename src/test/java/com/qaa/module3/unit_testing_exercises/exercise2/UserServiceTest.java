package com.qaa.module3.unit_testing_exercises.exercise2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
	
	private UserService service;

	@BeforeEach
	void setUp() throws Exception {
		service = new UserService();
	}

	@AfterEach
	void tearDown() throws Exception {
		service = null;
	}

	@Test
	void registerValidDetails() {
		// Arrange
		String username = "bobby", password = "Codes123";
		String expected = username;
		
		// Act
		String actual = service.register(username, password);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void registerInvalidPasswordNoNumbers() {
		// Arrange
		String username = "bobby", password = "CodesAlot";
		String expected = "Password must contain at least 1 number character";
		
		try {
			// Act
			service.register(username, password);
			fail("Expected an illegal argument exception due to missing number characters.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}
	
	@Test
	void registerInvalidPasswordNoUppercaseLetter() {
		// Arrange
		String username = "bobby", password = "codes123";
		String expected = "Password must contain at least 1 uppercase character";
		
		// Act
		IllegalArgumentException iae = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.register(username, password);
		}, "Expected an illegal argument exception due to missing uppercase characters.");
		
		// Assert
		Assertions.assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void loginValidDetails() {
		// Arrange
		String username = "bobby", password = "Codes123";
		String expected = username;
		service.register(username, password);
		
		// Act
		String actual = service.login(username, password);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void loginInvalidDetailsIncorrectPassword() {
		// Arrange
		String username = "bobby", password = "Codes123", wrongPassword = "Codes12";
		String expected = "Invalid password supplied";
		service.register(username, password);
		
		// Act
		IllegalArgumentException iae = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.login(username, wrongPassword);
		}, "Expected an illegal argument exception due to incorrect password on login.");
		
		// Assert
		Assertions.assertEquals(expected, iae.getMessage());
	}
}
