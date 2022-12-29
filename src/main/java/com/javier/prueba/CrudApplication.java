package com.javier.prueba;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javier.prueba.entity.User;
import com.javier.prueba.service.UserService;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (UserService userService) {
		return args ->{
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/posts.json");
			try {
				List<User> usuarios = mapper.readValue(inputStream, typeReference);
				userService.save(usuarios);
				System.out.println("Usuarios guardados");
			}catch(IOException e){
				System.out.println("No se pudo guardar usuarios " + e.getMessage());
			}
		};
	}
}
