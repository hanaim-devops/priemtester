package nl.han.devops;

import java.math.BigInteger;

import static org.apache.commons.numbers.primes.Primes.isPrime;

public class MavenPriemService implements PriemService {

    @Override
    public boolean isPriemgetal(int kandidaat) {
        return isPrime(kandidaat);
    }

    public boolean isPriemgetal(BigInteger kandidaat) {
        return kandidaat.isProbablePrime(10);
    }


}