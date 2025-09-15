package com.encora.purab.mind_on_paper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MindOnPaperApplication {

	public static void main(String[] args) {
		SpringApplication.run(MindOnPaperApplication.class, args);
	}

}
