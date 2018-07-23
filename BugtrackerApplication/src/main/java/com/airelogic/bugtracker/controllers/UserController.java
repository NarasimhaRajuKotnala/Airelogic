package com.airelogic.bugtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airelogic.bugtracker.models.User;
import com.airelogic.bugtracker.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value="/adduser")
	public String addUser(@RequestBody User user) {
		User userToPersist = userService.addUser(user);
		return "Created " + userToPersist.toString();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/getusers")
	public List<User> getAll(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/getuserbyusername/{userName}")
	public User getUserByUserName(@PathVariable String userName) {
		return userService.getByUserName(userName);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/updateuser")
	public String updateUserByUserName(@RequestBody User user) {
		User usertoUpdate = userService.update(user);
		return usertoUpdate.toString();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteuser/{userName}")
	public String delete(@PathVariable String userName) {
		userService.delete(userName);
		return "Deleted User: " + userName;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteallusers")
	public String deleteAll() {
		userService.deleteAll();
		return "Deleted all Users";
	}
	

}
