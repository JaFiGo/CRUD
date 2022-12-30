package com.javier.prueba.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javier.prueba.entity.User;
import com.javier.prueba.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	//llamamos UserService para utilizar sus funciones y utilizar la lista de usuarios
	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	//Solicitud Get para obtener la lista de usuarios 
	@GetMapping
	public Iterable<User> list(){
		return service.list();
	}
	
	//Solicitud Get para obtener el usuario deseado especificamente su id
	@GetMapping("/{id}")
	public User find (@PathVariable("id") int id) {
		return service.find(id);
	}
	
	//Solicitud Post para agregar un usuario al registro
	@PostMapping
	public User create(@RequestBody User user) {
		return service.save(user);
	}
	
	//Solicitud Delete para eliminar un usuario en especifico
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable("id") int id) {
		return service.delete(id);
	}
}
