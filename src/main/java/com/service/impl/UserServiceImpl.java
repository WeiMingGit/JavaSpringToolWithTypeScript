package com.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		return usersList.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
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
	
	@Override
	public Optional<User> updateUser(User user) {
		Optional<User> userOpt =  usersList.stream().filter(u -> u.getId() == user.getId()).findFirst();
		
		if(userOpt.isPresent()) {
			User existingUser = userOpt.get();
			
			if(user.getFirstName() != null) {
				existingUser.setFirstName(user.getFirstName());
			}
			if(user.getLastName() != null) {
				existingUser.setLastName(user.getLastName());
			}
			if(user.getAge() != null) {
				existingUser.setAge(user.getAge());
			}
			if(user.getCountry() != null) {
				existingUser.setCountry(user.getCountry());
			}
			
			usersList = usersList
					.stream()
					.filter(u -> u.getId() != existingUser.getId())
					.collect(Collectors.toList());
			usersList.add(existingUser);
			return Optional.of(existingUser);
			
						
		}
		
		return Optional.empty();
	}

	@Override
	public Optional<User> deleteUser(Long id) {
		Optional<User> userOpt =  usersList.stream().filter(user -> user.getId() == id).findFirst();
		
		if(userOpt.isPresent()) {
			usersList = usersList.stream().filter(user -> userOpt.get().getId() != user.getId()).collect(Collectors.toList());
			return userOpt;
		}
		
		return Optional.empty();
	}

	
	
	

}
