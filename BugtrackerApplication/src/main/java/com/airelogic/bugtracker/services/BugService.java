package com.airelogic.bugtracker.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airelogic.bugtracker.models.Bug;
import com.airelogic.bugtracker.repositories.BugRepository;

@Service
public class BugService {
	
	@Autowired
	private BugRepository bugRepository;

	//AddBug operation
	public Bug addBug(Bug bug) {
		return bugRepository.save(new Bug(
				   bug.getTitle(),
		           bug.getDescription(),
		           LocalDateTime.now(),
		           LocalDate.now().plusDays(5),
		           bug.getAssignedTo(),
		           bug.getUserId(),
		           bug.getViewedBy(),
		           bug.getWatchers(),
		           bug.getPriority(),
		           bug.getTags(),
		           bug.getComments(),
		           bug.getStatus()));

	}
	
	//Retrieve operation
	public List<Bug> getAll(){
		return bugRepository.findAll();
	}
	
	//Retrieve operation
	public Bug getByUserId(String userId) {
		return bugRepository.findByUserId(userId);
	}
	
	//Retrieve operation
	public List<Bug> getByStatusOpen() {
		List<Bug> bugs = new ArrayList<Bug>();
		List<Bug> returnbugs = new ArrayList<Bug>();
		
		bugs = bugRepository.findAll();
		
		for(Bug bug : bugs) {
			if(bug.getStatus().equalsIgnoreCase("open")) {
				returnbugs.add(bug);
			}
			
		}

		return returnbugs;

	}
	
	//Update bug by UserName
	public Bug updateBugByUserId(Bug bug) {
		Bug bugToUpdate = bugRepository.findByUserId(bug.getUserId());
		bugToUpdate.setDescription(bug.getDescription());
		bugToUpdate.setTimestamp(LocalDateTime.now());
		bugToUpdate.setDueDate(bug.getDueDate());
		bugToUpdate.setAssignedTo(bug.getAssignedTo());
		bugToUpdate.setUserId(bug.getUserId());
		bugToUpdate.setViewedBy(bug.getViewedBy());
		bugToUpdate.setWatchers(bug.getWatchers());
		bugToUpdate.setPriority(bug.getPriority());
		bugToUpdate.setTags(bug.getTags());
		bugToUpdate.setComments(bug.getComments());
		bugToUpdate.setStatus(bug.getStatus());
		
		return bugRepository.save(bugToUpdate);
	}
	

	//Delete operation
	public void deleteAll() {
		bugRepository.deleteAll();
	}
	
	
	//delete bug by UserName
	public void deleteBugByUserId(String userId) {
		Bug bug = bugRepository.findByUserId(userId);
		bugRepository.delete(bug);
	}


}
