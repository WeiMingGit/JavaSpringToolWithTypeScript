package com.service;

import java.util.List;
import java.util.Optional;

import com.model.User;

public interface UserService {
	
	
	public List<User> findAll();
	
	public Optional<User> findById(Long id);
	
	public void addUser(User user);
	
	public Optional<User> deleteUser(Long id);
	
	public Optional<User> updateUser(User user);

}
