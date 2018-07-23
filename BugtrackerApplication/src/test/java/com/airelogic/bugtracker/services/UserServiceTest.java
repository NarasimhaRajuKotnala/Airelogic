/*package com.airelogic.bugtracker.services;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.airelogic.bugtracker.AbstractTest;
import com.airelogic.bugtracker.models.User;
import com.airelogic.bugtracker.repositories.UserRepository;

@Transactional

public class UserServiceTest extends AbstractTest{
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Before
	public void setUp() {
	
		
		userRepository.save(new User("Narasimha", "Kotnala", "narasimha.kotnala@yahoo.com","kot"));
		userRepository.save(new User("Rachel", "Lintott","rachel.lintott@yahoo.com","lint"));
		userRepository.save(new User("Matthew", "Stewart","matthew.stewart@yahoo.com","stew"));
		userRepository.save(new User("Richard", "Joseph","richard.joseph@yahoo.com","rjos"));
		userRepository.save(new User("Monika", "Verma","monika.verma@yahoo.com","verma"));
		
	}
	
	@After
	public void tearDown() {
		//clean up after test method
	}
	
	@Test
	public void testGetAllUsers() {
		
		List<User> user = userService.getAllUsers();
		
		Assert.assertNotNull("failure - expected not null", user);
		Assert.assertEquals("failure - expected size", 5, user.size());
		
	}

}
*/