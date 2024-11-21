package nl.han.devops;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PriemController.class)
public class PriemTesterIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PriemService priemService;

    @Test
    public void testCheckIfPrime_withInteger() throws Exception {
        // Mocking the service.
        var input1 = "7";
        var input2 = "4";

        // when(priemService.isPriemgetal(input1)).thenReturn(true);
        // when(priemService.isPriemgetal(4)).thenReturn(false);

        // Sending request with a prime number
        mockMvc.perform(post("/priem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(input1))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        // Sending request with a non-prime number
        mockMvc.perform(post("/priem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(input2))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    public void testCheckIfPrime_withPrimeBigInteger() throws Exception {
        // Mocking the service
        var input1 = new BigInteger("104729");

        // Sending request with a large prime number
        mockMvc.perform(post("/priem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(input1.toString()))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void testCheckIfPrime_withNonPrimeBigInteger() throws Exception {
        // Mocking the service
        var input2 = new BigInteger("104728");
        // when(priemService.isPriemgetal(input2)).thenReturn(false);

        // Sending request with a large non-prime number
        mockMvc.perform(post("/priem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("" + input2))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    public void testInvalidInput() throws Exception {
        // Arrange
        String input = "not_a_number";

        // Act and Assert
        mockMvc.perform(post("/priem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("\"" + input + "\"")) // Wrap the input in quotes to mimic JSON string
                .andExpect(status().isBadRequest()) // Assert 400 status
                .andExpect(content().string("Invalid input: Not a valid number")); // Assert error message
    }

    @Test
    public void testGetEndpoint() throws Exception {
        // Testing the GET endpoint
        mockMvc.perform(get("/priem"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, world!"));
    }
}
