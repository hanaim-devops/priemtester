package nl.han.devops;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PriemTesterTest {

	private final PriemTester priemTester = new PriemTester();

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 1})
	public void isPriemgetal_WaardenKleinerDan2_ReturnFalse(int value) {
		boolean result = priemTester.isPriemgetal(value);

		Assertions.assertFalse(result, value + " zou geen priemgetal moeten zijn.");
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20})
	public void isPriemgetal_onwaarden_voor_niet_priemgetallen(int value) {
		boolean result = priemTester.isPriemgetal(value);

		Assertions.assertFalse(result, value + " zou geen priemgetal moeten zijn.");
	}
	@ParameterizedTest
	@ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19})
	public void isPriemgetal_waar_voor_priemgetallen(int value) {
		boolean result = priemTester.isPriemgetal(value);

		Assertions.assertTrue(result, value + " zou een priemgetal moeten zijn.");
	}

}