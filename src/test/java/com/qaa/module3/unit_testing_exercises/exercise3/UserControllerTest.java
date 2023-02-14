package com.qaa.module3.unit_testing_exercises.exercise3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserController userController;

	@Test
	void registerValidDetailsTest() {
		// Arrange
		User user = new User(0, "Bobby", "Codes123");
		User expected = new User(1, user.getUsername(), user.getPassword());
		Mockito.when(userRepository.exists(user.getUsername())).thenReturn(false);
		Mockito.when(userRepository.register(user)).thenReturn(expected);
		
		// Act
		User actual = userController.register(user);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void loginValidDetailsTest() {
		// Arrange
		User user = new User(0, "Bobby", "Codes123");
		User expected = new User(1, user.getUsername(), user.getPassword());
		Mockito.when(userRepository.login(user)).thenReturn(expected);
		
		// Act
		User actual = userController.login(user);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}
}
