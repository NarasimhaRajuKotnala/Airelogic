package com.airelogic.bugtracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airelogic.bugtracker.models.User;
import com.airelogic.bugtracker.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//Create operation
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	//Retrieve operation
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public User update(User user) {
		User usertoUpdate = userRepository.findByUserName(user.getUserName());
		usertoUpdate.setFirstName(user.getFirstName());
		usertoUpdate.setLastName(user.getLastName());
		usertoUpdate.setPassword(user.getPassword());
		usertoUpdate.setUserName(user.getUserName());
		return userRepository.save(usertoUpdate);
	}
	
	//Delete operation
	public void deleteAll() {
		userRepository.deleteAll();
	}
	
	public void delete(String userName) {
		User user = userRepository.findByUserName(userName);
		userRepository.delete(user);
	}



}
