package br.com.gilpeixoto.cursotestes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gilpeixoto.cursotestes.domain.User;

@SpringBootApplication
public class CursotestesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursotestesApplication.class, args);

		User usr = new User(1, "gil", "araujo.gil27@gmail.com", "123456");

		usr.toString();
	}

}
