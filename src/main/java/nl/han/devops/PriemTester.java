package nl.han.devops;

public class PriemTester {

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
}