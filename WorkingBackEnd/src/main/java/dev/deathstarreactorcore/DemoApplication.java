package dev.deathstarreactorcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//User and password have been seperated because we should be able to return a user to the frontend without risking a security breach. If the password is included in the user objects the JSON representation will include the password which ought to be avoided.

@SpringBootConfiguration
@SpringBootApplication
@ComponentScan("dev.deathstarreactorcore")
@EnableJpaRepositories("dev.deathstarreactorcore.repositories")
@EntityScan("dev.deathstarreactorcore.beans")

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
