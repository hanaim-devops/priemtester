package nl.han.devops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.Map;

@RestController
@RequestMapping("/priem")
public class PriemController {

    private final PriemService priemService;

    @Autowired
    public PriemController(PriemService priemService) {
        this.priemService = priemService;
    }

    @PostMapping
    public Map<String, Boolean> checkIfPrime(@RequestBody Map<String, String> request) {
        // Verwacht een JSON met een veld "number" als string
        BigInteger number = new BigInteger(request.get("number"));

        // Roep de service aan om te controleren of het getal priem is
        boolean isPrime = priemService.isPriemgetal(number);

        // Retourneer het resultaat als JSON
        return Map.of("isPrime", isPrime);
    }

    // Add a test GET endpoint, that returns a 'hello world' string.
    // http://localhost:8080/priem
    @GetMapping
    public String test() {
        return "Hello, world!";
    }

    @GetMapping("/check")
    public Map<String, Boolean> checkIfPrime(@RequestParam("number") String number) {
        var bigInteger = new BigInteger(number);
        var isPrime = priemService.isPriemgetal(bigInteger);
        return Map.of("isPrime", isPrime);
    }
}
