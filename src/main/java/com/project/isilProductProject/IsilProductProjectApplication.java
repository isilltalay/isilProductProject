package com.project.isilProductProject;

import com.project.isilProductProject.entities.User;
import com.project.isilProductProject.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication()
public class IsilProductProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsilProductProjectApplication.class, args);
	}
}
