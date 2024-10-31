package nl.han.devops;

import java.math.BigInteger;

import static org.apache.commons.numbers.primes.Primes.isPrime;

public class MavenPriemTester implements PriemTester {

    @Override
    public boolean isPriemgetal(int kandidaat) {
        return isPrime(kandidaat);
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