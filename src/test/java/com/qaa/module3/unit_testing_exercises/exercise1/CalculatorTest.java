package com.qaa.module3.unit_testing_exercises.exercise1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	private Calculator calculator;

	@BeforeEach
	void setUp() throws Exception {
		calculator = new Calculator();
	}

	@AfterEach
	void tearDown() throws Exception {
		calculator = null;
	}

	@Test
	void addSmallNumbersTest() {
		// Arrange
		double num1 = 10, num2 = 20;
		double expected = 30;
		
		// Act
		double actual = calculator.add(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void subtractSmallNumbersTest() {
		// Arrange
		double num1 = 10, num2 = 20;
		double expected = -10;
		
		// Act
		double actual = calculator.subtract(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void multiplySmallNumbersTest() {
		// Arrange
		double num1 = 10, num2 = 20;
		double expected = 200;
		
		// Act
		double actual = calculator.multiply(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void divideSmallNumbersTest() {
		// Arrange
		double num1 = 10, num2 = 20;
		double expected = 0.5;
		
		// Act
		double actual = calculator.divide(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}
	
}
