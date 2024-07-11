package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import com.promineotech.TestDemo;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class TestDemoJUnitTest {
	private TestDemo testDemo;
	
	@BeforeEach
	public void setUp() {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource ("com.promineotech.TestDemoJUnitTest#arugmentsForAddPositive")
	public void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	public static Stream<Object> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(3, 5, 8, false),
				arguments(1, -1, 0, true),
				arguments(3, -4, -1, true),
				arguments(6, 3, 9, false),
				arguments(3, -4, -1, true),
				arguments(0, -2, 4, true)
				);
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(43, 24)) .isEqualTo(67);
		assertThat(testDemo.addPositive(17, 25)).isEqualTo(42);
	}
	
	@Test
	void assertThatTwoNumbersAreMultipliedCorrectlyThenDividedByAnotherNumber () {
		assertThat(testDemo.multiplyThenDivide(2, 4, 5)).isEqualTo(1.6);
		assertThat(testDemo.multiplyThenDivide(-2, 4, 5)).isEqualTo(-1.6);
		assertThat (testDemo.multiplyThenDivide(45, 55, 36)).isEqualTo(68.75);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect () {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo. randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
}
