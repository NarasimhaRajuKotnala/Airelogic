package com.airelogic.bugtracker.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airelogic.bugtracker.models.History;

public interface HistoryRepository extends MongoRepository<History, String> {
	
	public Optional<History> findById(String Id);
	public History findByBugId(String bugId);
	public History findByUserId(String userId);
	public History findByAction(String action);
	public void deleteByUserId(String userId);
	public void deleteByBugId(String bugId);
}
