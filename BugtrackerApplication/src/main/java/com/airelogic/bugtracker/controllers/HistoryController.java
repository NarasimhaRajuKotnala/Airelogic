package com.airelogic.bugtracker.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airelogic.bugtracker.models.History;
import com.airelogic.bugtracker.services.HistoryService;

@RestController
public class HistoryController {
	
	@Autowired
	private HistoryService historyService;
	

	@RequestMapping(method = RequestMethod.POST, value="/addhistory")
	public String create(@RequestBody History history) {
		History historytoPersist = historyService.create(history.getBugId(),history.getUserId(),history.getAction(),LocalDateTime.now());
		return historytoPersist.toString();
	}
	
	@GetMapping("/getallhistory")
	public List<History> getAll(){
		return historyService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/gethistorybyuserid/{userId}")
	public History getHistoryByUserId(@PathVariable String userId) {
		return historyService.getByUserId(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/gethistorybybugid/{bugId}")
	public History getByBugId(@PathVariable String bugId) {
		return historyService.getByBugId(bugId);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/updatehistorybybugid")
	public String updateByBugId(@RequestBody History history) {
		History historyToUpdate = historyService.updateByBugId(history);
		return historyToUpdate.toString();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/updatehistorybyuserid")
	public String updateByUserId(@RequestBody History history) {
		History historyToUpdate = historyService.updateByUserId(history);
		return "Updated History" + historyToUpdate.toString();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deletehistorybybugid/{bugId}")
	public String deleteByBugId(@PathVariable String bugId) {
		historyService.deleteByBugId(bugId);
		return "Deleted history for Bug : " + bugId;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deletehistorybyuserid/{userId}")
	public String deleteByUserId(@PathVariable String userId) {
		historyService.deleteByUserId(userId);
		return "Deleted history for User : " + userId;
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteallhistory")
	public String deleteAll() {
		historyService.deleteAll();
		return "Deleted all records";
	}
	
	
	
}
