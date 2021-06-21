package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.model.User;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	public static List<User> usersList = new ArrayList<>();
	private static Long COUNTER = (long) 1;
	
	static {
		User user = new User(COUNTER++, "Aleena", "Chan", 24, "USA");
		usersList.add(user);
		user = new User(COUNTER++, "Annie", "Carr", 30, "BRAZIL");
		usersList.add(user);
		user = new User(COUNTER++, "Louisa", "Patterson", 22, "SINGAPORE");
		usersList.add(user);
		user = new User(COUNTER++, "Cara", "Allen", 13, "MALAYSIA");
		usersList.add(user);
		user = new User(COUNTER++, "Jodie", "Stuart", 72, "INDONESIA");
		usersList.add(user);
	}
	
	@Override
	public List<User> findAll() {
		return usersList;
	}

	@Override
	public Optional<User> findById(Long id) {
		return usersList.stream().filter(user -> user.getId() == id).findFirst();
	}

	@Override
	public void addUser(User user) {
		user.setId(COUNTER++);
		usersList.add(user);
		
	}
	
	

}
