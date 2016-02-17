package aplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import domain.User;
import service.UserRepository;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(UserInfo.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}