package com.javier.prueba.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javier.prueba.entity.User;
import com.javier.prueba.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping
	public Iterable<User> list(){
		return service.list();
	}
	
	@GetMapping("/{uid}/{id}")
	public User find (@PathVariable("uid") int uid, @PathVariable("id") int id) {
		return service.find(uid,id);
	}
	
	@PostMapping
	public User create(@RequestBody User user) {
		return service.save(user);
	}
	
	@PutMapping("/{uid}/{id}")
	public User update(@PathVariable("uid") int uid, @PathVariable("id") int id, @RequestBody User user) {
		return service.update(uid,id,user);
	}
	
	@DeleteMapping("/{uid}/{id}")
	public boolean delete(@PathVariable("uid") int uid, @PathVariable("id") int id) {
		return service.delete(uid, id);
	}
}
