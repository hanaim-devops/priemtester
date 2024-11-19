package nl.han.devops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Bron: https://spring.io/guides/gs/testing-web
// Spring Boot test? Je moet toch alleen je eigen code testen, niet de frameworks of libraries die je gebruikt.
@SpringBootTest
@AutoConfigureMockMvc
class PriemControllerIntegrationTest {

        @Autowired
        private PriemController sut;

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private PriemService mockPriemService;

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
            when(mockPriemService.isPriemgetal(3)).thenReturn(true);

            // Act and Assert.
            mockMvc.perform(post("/priem")
                    .param("number", "3"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("true"));

        }
}
