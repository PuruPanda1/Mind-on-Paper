package com.encora.purab.mind_on_paper;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(
        info = @Info(
                title = "Mind on Paper API",
                version = "1.0",
                description = "API documentation for Mind on Paper"
        )
)
public class MindOnPaperApplication {

	public static void main(String[] args) {
		SpringApplication.run(MindOnPaperApplication.class, args);
	}

}
