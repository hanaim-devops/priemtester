package nl.han.devops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.instancio.Instancio;

import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Bron: https://spring.io/guides/gs/testing-web
// Spring Boot test? Je moet toch alleen je eigen code testen, niet de frameworks of libraries die je gebruikt.
@SpringBootTest
@AutoConfigureMockMvc
class PriemControllerIT {

        @Autowired
        private PriemController sut;

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private PriemService mockPriemService;

        private PriemService priemService;

    @BeforeEach
        void setUp() {
            sut = new PriemController(mockPriemService);
        }

        @Test
        void contextLoads() {
            assertThat(sut).isNotNull();
        }

        @Test
        void PriemControllerUnitTestReturnsTrue() throws Exception {
            // Arrange.
            var input = 3;
            when(mockPriemService.isPriemgetal(input)).thenReturn(true);
            var expected = "true";

            // Act and Assert.
            mockMvc
                    .perform(post("/priem")
                   .contentType(MediaType.APPLICATION_JSON)
                    .content(input + ""))
                    // .param("number", "3"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(expected));
        }

    @Test
    @Disabled
    void PriemControllerUnitTestWhateverItsServiceReturns() throws Exception {
        // Arrange.
        // Create random dummy value using framework Instancio
        // Bron: https://dzone.com/articles/instancio-random-test-data-generator-for-java
        var dummyBoolean = Instancio.create(Boolean.class);
        when(mockPriemService.isPriemgetal(3)).thenReturn(dummyBoolean);

        // Act and Assert.
        mockMvc.perform(post("/priem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("3"))
                // .param("number", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    // Temporartily disabled test with annotation @Disabled
    @Disabled
    @Test
    void PriemControllerReturnsTrueForThree() throws Exception {
        // Arrange.
        priemService = new CustomPriemService();

        // Act and Assert.
        mockMvc.perform(post("/priem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("3"))
                // .param("number", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

}
