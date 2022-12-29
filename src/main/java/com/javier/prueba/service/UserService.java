package com.javier.prueba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javier.prueba.entity.User;

@Service
public class UserService {
	//inicializacion de lista que contendrá los datos del CRUD
	private List<User> usuarios = new ArrayList<>();
	
	//Funcion de retorno de usuarios
	public List<User> list(){
		return usuarios;
	}
	
	//funcion para encontrar un usuario registrado
	public User find(int uId, int id) {
		//si encuentra el ususario por su id lo devuelve, caso contrario retorna un null
		for (User u: usuarios) {
			if(u.getUserId() == uId && u.getId() == id) {
				return u;
			}
		}
		return null;
	}
	
	//funcion para almacenar un usuario en el registro
	public User save(User u) {
		usuarios.add(u);
		return u;
	}
	
	//funcion para almacenar usuarios provenientes de una lista
	public List<User> save(List<User> users){
		for (User u : users) {
			usuarios.add(u);
		}
		return users;
	}
	
	//funcion para actualizar un usuario
	public User update(int uId,int id, User us) {
		int cont = 0;
		for (User u: usuarios) {
			if(u.getUserId() == uId && u.getId() == id) {
				us.setUserId(uId);
				us.setId(id);
				usuarios.set(cont, us);
			}
			cont++;
		}
		return us;
	}
	
	//funcion para eleminar usuarios en base a su userId y su id
	public boolean delete(int uId,int id) {
		for (User u: usuarios) {
			if(u.getUserId() == uId && u.getId() == id) {
				return usuarios.remove(u);
			}
		}
		return false;
	}
}
