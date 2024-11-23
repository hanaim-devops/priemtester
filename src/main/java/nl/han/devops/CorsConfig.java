package nl.han.devops;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Toestaan voor alle endpoints
                        .allowedOrigins("http://localhost:5173") // Alleen frontend URL toestaan
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Toegestane HTTP-methoden
                        .allowedHeaders("*") // Toegestane headers
                        .allowCredentials(true); // Cookies toestaan als nodig
            }
        };
    }
}
