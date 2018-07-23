package com.airelogic.bugtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airelogic.bugtracker.models.Bug;
import com.airelogic.bugtracker.services.BugService;

@RestController
public class BugController {
	
	@Autowired
	private BugService bugService;

	@RequestMapping(method = RequestMethod.POST, value="/addbug")
	public String addBug(@RequestBody Bug bug) {
		Bug bugToPersist = bugService.addBug(bug);
		return "Created " + bugToPersist.toString();
	}

	@GetMapping("/getbugs")
	public List<Bug> getAll(){
		return bugService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/getbugbyuserid/{userId}")
	public Bug getBugByUserId(@PathVariable String userId) {
		return bugService.getByUserId(userId);
	}
	
	@GetMapping("/getbugbystatusopen")
	public List<Bug> getBugByStatusOpen() {
		 return bugService.getByStatusOpen();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/updatebugbyuserid")
	public String updateBugByUserName(@RequestBody Bug bug) {
		Bug bugToUpdate = bugService.updateBugByUserId(bug);
		return bugToUpdate.toString();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deletebugbyuserid/{userId}")
	public String deleteBugByUserId(@PathVariable String userId) {
		bugService.deleteBugByUserId(userId);
		return "Deleted Bug with UserId: " + userId;
	}
	
	@RequestMapping("/deleteallbugs")
	public String deleteAll() {
		bugService.deleteAll();
		return "Deleted all bugs";
	}
	
	
	
}
