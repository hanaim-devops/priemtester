package nl.han.devops;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

public interface PriemService {
    boolean isPriemgetal(int kandidaat);
    public boolean isPriemgetal(BigInteger kandidaat);
}
