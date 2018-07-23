package com.airelogic.bugtracker.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.airelogic.bugtracker.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	public User findByUserName(String userName);
	public User findByFirstName(String firstName);
	
}
