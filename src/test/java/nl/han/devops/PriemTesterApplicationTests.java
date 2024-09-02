package nl.han.devops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PriemTesterApplicationTests {

	PriemTester sut;

	@BeforeAll
	void beforeAll() {
		sut = new PriemTester();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void PriemTester_1_is_een_priemgetal() {
		// Arrange.
		// TODO Refactoren dit soort herhalende code.
		// DAMP: DRY voor unit tests: Descriptive And Meaningfull Phrases (Seemann, M. .
		sut = new PriemTester();

		var input = 1;
		var expected = true;

		// Act.
		var actual = sut.isPriemgetal(input);

		// Assert.
		Assertions.assertEquals(actual, expected);
	}

	@Test
	void PriemTester_2_is_geen_priemgetal() {
		// Arrange.
		// TODO Refactoren dit soort herhalende code.
		// DAMP: DRY voor unit tests: Descriptive And Meaningfull Phrases.
		sut = new PriemTester();

		var input = 2;
		var expected = false;

		// Act.
		var actual = sut.isPriemgetal(input);

		// Assert.
		Assertions.assertEquals(actual, expected);
	}
}
