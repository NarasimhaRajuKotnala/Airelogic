package com.airelogic.bugtracker.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airelogic.bugtracker.models.Bug;

public interface BugRepository extends MongoRepository<Bug, String> {
	
	public Bug findByUserId(String userId);
	public Bug findByStatus(String status);
	public void deleteByUserId(String userId);


}
