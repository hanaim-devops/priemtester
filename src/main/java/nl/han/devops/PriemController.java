package nl.han.devops;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;

@RestController
@RequestMapping("/priem")
// @Tag(name = "PriemController", description = "Endpoints for prime number checking")
public class PriemController {

    private final PriemService priemService;

    @Autowired
    public PriemController(PriemService priemService) {
        this.priemService = priemService;
    }

    @PostMapping
    public Boolean checkOfPriem(@RequestBody NumberRequest input) {
        String numberStr = input.getNumber();
        try {
            // First, try to parse as Integer
            Integer intValue = Integer.valueOf(numberStr);
            return priemService.isPriemgetal(intValue);
        } catch (NumberFormatException ex) {
            // If it fails, parse as BigInteger
            // TODO: Alleen toestaan voor ingelogde gebruikers.
            try {
                BigInteger bigIntValue = new BigInteger(numberStr);
                return priemService.isPriemgetal(bigIntValue);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input: Not a valid number");
            }
        }
    }
}
