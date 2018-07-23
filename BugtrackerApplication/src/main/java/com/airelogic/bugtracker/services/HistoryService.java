package com.airelogic.bugtracker.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airelogic.bugtracker.models.History;
import com.airelogic.bugtracker.repositories.HistoryRepository;

@Service
public class HistoryService {
	
	@Autowired
	private HistoryRepository historyRepository;
	
	
	//Create operation
	public History create(String bugId, String userId, String action, LocalDateTime timestamp) {
		return historyRepository.save(new History(bugId, userId, action,timestamp));
	}
	
	//Retrieve operation
	public List<History> getAll(){
		return historyRepository.findAll();
	}
	
	public History getByUserId(String userId) {
		return historyRepository.findByUserId(userId);
	}
	
	public History getByBugId(String bugId) {
		return historyRepository.findByBugId(bugId);
	}
	
	public History updateByBugId(History history) {
		
		History historyToUpdate = historyRepository.findByBugId(history.getBugId());
				historyToUpdate.setUserId(history.getUserId());
				historyToUpdate.setAction(history.getAction());
				historyToUpdate.setTimestamp(LocalDateTime.now());
		return  historyRepository.save(historyToUpdate);
		        
	}
	
	public History updateByUserId(History history) {
		
		History historyToUpdate = historyRepository.findByUserId(history.getUserId());
				historyToUpdate.setBugId(historyToUpdate.getBugId());
				historyToUpdate.setAction(historyToUpdate.getAction());
				historyToUpdate.setTimestamp(LocalDateTime.now());
		 return historyRepository.save(history);
		        
	}
	
	//Delete operation
	public void deleteAll() {
		historyRepository.deleteAll();
	}
	
	//delete user by BugId
	public void deleteByBugId(String bugId) {
		historyRepository.deleteByBugId(bugId);
	}
	
	//delete user by UserId
	public void deleteByUserId(String userId) {
		historyRepository.deleteByUserId(userId);
	}


}
