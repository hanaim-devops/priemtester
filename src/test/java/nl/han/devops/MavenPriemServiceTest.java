package nl.han.devops;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MavenPriemServiceTest {

    private final PriemService priemService = new MavenPriemService();

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    public void isPriemgetal_waar_voor_getallen_kleiner_dan_twee(int value) {
        boolean result = priemService.isPriemgetal(value);

        Assertions.assertFalse(result, value + " zou geen priemgetal moeten zijn.");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20})
    public void isPriemgetal_onwaar_voor_niet_priemgetallen(int value) {
        boolean result = priemService.isPriemgetal(value);

        Assertions.assertFalse(result, value + " zou geen priemgetal moeten zijn.");
    }
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19})
    public void isPriemgetal_waar_voor_priemgetallen(int value) {
        boolean result = priemService.isPriemgetal(value);

        Assertions.assertTrue(result, value + " zou een priemgetal moeten zijn.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"101", "103", "1009", "104729", "1299709", "15485863"})
    public void isPriemgetal_waar_voor_BigInteger_priemgetallen(int value) {
        boolean result = priemService.isPriemgetal(value);

        Assertions.assertTrue(result, value + " zou een BigInteger priemgetal moeten zijn.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "102", "1000", "104730", "1299710", "15485864", "32452844"})
    public void isPriemgetal_onwaar_voor_BigInteger_niet_priemgetallen(int value) {
        boolean result = priemService.isPriemgetal(value);

        Assertions.assertFalse(result, value + " zou geen priemgetal moeten zijn.");
    }

}
