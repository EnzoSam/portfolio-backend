package com.portfolio.same.portfoliobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PortfolioBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioBackendApplication.class, args);
	}
        
	@Bean
	public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                    @Override
                    public void addCorsMappings(CorsRegistry registry) {
                            registry.addMapping("/**")
                                    .allowedOrigins("https://portfolio-fb9ed.web.app")
                                    .allowedMethods("*")
                                    .allowedHeaders("*");;
                    }
            };
	}        

}
