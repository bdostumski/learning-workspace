package com.example.unitandintegrationtesting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
class UnitAndIntegrationTestingApplicationTests {

	private final Calculator underTest = new Calculator();

	@Test
	void itShouldAddTwoNumbers() {

		// given
		int numberOne = 20;
		int numberTwo = 30;

		// when
		int result = underTest.add(numberOne, numberTwo);

		// then
		int expected = 50;
		assertThat(result).isEqualTo(expected);

	}

	private static class Calculator {
		private int add(int x, int y) {
			return x + y;
		}
	}

}
