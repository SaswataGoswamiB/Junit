package com.JunitTest.Tdd;

import java.security.PublicKey;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {

	// If the no is deivisble by 3 ---->Fizz.
	// No divisible by 5--------------->Buzz.
	// Both by 3 and 5----->FizzBuzz.

	@Test
	@DisplayName("Divisibility by 3")
	@Order(1)
	void testfailDivbyThree() {
		// Assertions.fail("Fail");

		String expectedString = "Fizz";
		Assertions.assertEquals(expectedString, FizzBuzz.compute(3));
	}

	@Test
	@DisplayName("Divisibility by 5")
	@Order(3)
	void testfailDivbyFive() {
		// Assertions.fail("Fail");

		String expectedString = "Buzz";
		Assertions.assertEquals(expectedString, FizzBuzz.compute(5));
	}

	@Test
	@DisplayName("Divisibility by 3 and  5")
	@Order(2)
	void testfailDivbyFiveandThree() {
		// Assertions.fail("Fail");

		String expectedString = "FizzBuzz";
		Assertions.assertEquals(expectedString, FizzBuzz.compute(15));
	}

	@ParameterizedTest()
	@DisplayName("Testuing with CSV data.")
	@CsvSource({ "1,1", "2,2", "3,Fizz", "5,Buzz", "15,FizzBuzz" })
	void testCsvData(int a, String expected) {
		Assertions.assertEquals(expected, FizzBuzz.compute(a));
	}

	// Customizing the Invocation Names.
	@ParameterizedTest(name = "value={0},expected={1}")
	@DisplayName("Testuing with CSV data.")
	@CsvSource({ "1,1", "2,2", "3,Fizz", "5,Buzz", "15,FizzBuzz" })
	
	void testCsvDatatwo(int a, String expected) {
		Assertions.assertEquals(expected, FizzBuzz.compute(a));

	}

}
