package nl.han.devops;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CustomPriemService implements PriemService {

    @Override
    public boolean isPriemgetal(int kandidaat) {
        // Als het getal kleiner is dan 2, is het geen priemgetal
        if (kandidaat < 2) {
            return false;
        }

        // Controleer divisors tot en met de vierkantswortel van de kandidaat
        for (int deler = 2; deler <= Math.sqrt(kandidaat); deler++) {
            if (kandidaat % deler == 0) {
                return false; // Als er een deler is, is het geen priemgetal
            }
        }

        // Als geen delers zijn gevonden, is het getal een priemgetal
        return true;
    }

    public boolean isPriemgetal(BigInteger kandidaat) {
        // Gebruik standaard BigInteger ProbablePrime
        var result = kandidaat.isProbablePrime(15);

        if (!result) {
            return false;
        }

        // Bron: https://chatgpt.com/share/672385e0-3ecc-8012-904f-75b95fbf69f3
        // Voor een deterministische test, probeer te delen door alle priemgetallen kleiner dan √kandidaat
        BigInteger sqrt = kandidaat.sqrt();
        BigInteger i = BigInteger.valueOf(2);

        while (i.compareTo(sqrt) <= 0) {
            if (kandidaat.mod(i).equals(BigInteger.ZERO)) {
                return false;  // Kan gedeeld worden, dus niet priem
            }
            i = i.nextProbablePrime();  // Spring naar het volgende priemgetal
        }

        // Geen factoren gevonden, dus het is een priemgetal
        return true;
    }
}