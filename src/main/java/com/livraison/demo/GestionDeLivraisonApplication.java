package com.livraison.demo;

import com.livraison.demo.entity.User;
import com.livraison.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class GestionDeLivraisonApplication {
@Autowired
	private UserRepository repository;

@PostConstruct
	public void initUsers(){
		List<User> users = Stream.of(
				new User(0, "SuperAdmin", "password", "hassan@souhaib.com"),
				new User(1, "majid", "pwd1", "user1@gmail.com"),
				new User(2, "kassmi", "pwd2", "user2@gmail.com"),
				new User(3, "med", "pwd3", "user3@gmail.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}
	public static void main(String[] args) {
		SpringApplication.run(GestionDeLivraisonApplication.class, args);
	}

}
