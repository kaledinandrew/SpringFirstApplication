package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@ComponentScan({"entity_person", "entity_message"})
@EntityScan({"entity_person", "entity_message"})
@EnableJpaRepositories(basePackages= {"entity_person", "entity_message"})
public class SpringStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringStartApplication.class, args);
	}
}
