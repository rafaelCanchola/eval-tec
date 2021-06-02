package com.rc.evaltec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EvaluacionTecApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluacionTecApplication.class, args);
	}
	
	@Autowired
	private Environment env;
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/ejercicioUno").allowedOrigins(env.getProperty("app.cross.origins"));
				registry.addMapping("/api/ejercicioTres").allowedOrigins(env.getProperty("app.cross.origins"));
				registry.addMapping("/api/ejercicioCinco").allowedOrigins(env.getProperty("app.cross.origins"));
				registry.addMapping("/api/ejercicioSiete").allowedOrigins(env.getProperty("app.cross.origins"));
				registry.addMapping("/api/cargar").allowedOrigins(env.getProperty("app.cross.origins"));
				
			}
		};
	}

}
