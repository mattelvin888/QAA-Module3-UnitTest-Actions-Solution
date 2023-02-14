package com.qaa.module3.unit_testing_exercises.exercise2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
	
	private UserService service = new UserService();

	@BeforeEach
	public void setUp() throws Exception {
		service = new UserService();
	}

	@AfterEach
	public void tearDown() throws Exception {
		service = null;
	}

	@Test
	public void testRegisterValidDetails() {
		// Arrange
		String username = "bobby", password = "Codes123";
		String expected = username;
		
		// Act
		String actual = service.register(username, password);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testRegisterInvalidPasswordNoNumbers() {
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
	public void testRegisterInvalidPasswordNoUppercaseLetter() {
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
	public void testLoginValidDetails() {
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
	public void testLoginInvalidDetailsIncorrectPassword() {
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
