package nl.han.devops;

import io.swagger.v3.oas.annotations.tags.Tag;
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
    @Tag(name = "PriemController", description = "Endpoints for prime number checking")
    public Boolean checkIfPrime(@RequestBody String input) {
        BigInteger number;
        try {
            // Check of de String wel een BigInteger is.
            number = new BigInteger(input);
        } catch (NumberFormatException e) {
            // Als het geen BigInteger is, retourneer false.
            return false;
        }

        // Roep de service aan om te controleren of het getal priem is.
        boolean isPrime = priemService.isPriemgetal(number);

        // Retourneer het resultaat (Jackson zet dit automatisch om naar JSON.
        return isPrime;
    }

    // Add a test GET endpoint, that returns a 'hello world' string.
    // http://localhost:8080/priem
    @GetMapping
    public String test() {
        return "Hello, world!";
    }
}
