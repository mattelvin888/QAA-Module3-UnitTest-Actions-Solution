package com.qaa.module3.unit_testing_exercises.exercise1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	private Calculator calculator;

	/*
	Junit is not invoking the setUp and tearDown methods, so as a workaround
	they are currently invoked manually at the start/end of each test.
	*/

	@BeforeEach
	public void setUp() {
		calculator = new Calculator();
	}

	@AfterEach
	public void tearDown() {
		calculator = null;
	}

	@Test
	public void testAddSmallNumbersTest() {
		setUp();
		// Arrange
		double num1 = 10, num2 = 20;
		double expected = 30;
		
		// Act
		double actual = calculator.add(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
		tearDown();
	}
	
	@Test
	public void testSubtractSmallNumbersTest() {
		setUp();
		// Arrange
		double num1 = 10, num2 = 20;
		double expected = -10;
		
		// Act
		double actual = calculator.subtract(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
		tearDown();
	}

	@Test
	public void testMultiplySmallNumbersTest() {
		setUp();
		// Arrange
		double num1 = 10, num2 = 20;
		double expected = 200;
		
		// Act
		double actual = calculator.multiply(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
		tearDown();
	}
	
	@Test
	public void testDivideSmallNumbersTest() {
		setUp();
		// Arrange
		double num1 = 10, num2 = 20;
		double expected = 0.5;
		
		// Act
		double actual = calculator.divide(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
		tearDown();
	}
	
}
