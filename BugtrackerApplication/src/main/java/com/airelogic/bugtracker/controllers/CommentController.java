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

import com.airelogic.bugtracker.models.Comment;
import com.airelogic.bugtracker.services.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	@RequestMapping(method = RequestMethod.POST, value="/addcomment")
	public String addComment(@RequestBody Comment comment) {
		Comment commentToSave = commentService.addComment(comment);
		return "Added Comment: " + commentToSave.toString();
	}
	
	@GetMapping("/getallcomments")
	public List<Comment> getAll(){
		return commentService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/getcommentbyusername/{userName}")
	public Comment getCommentByUserName(@PathVariable String userName) {
		return commentService.getByUserName(userName);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/getcommentbybugid/{bugId}")
	public Comment getCommentByBugId(@PathVariable String bugId) {
		return commentService.getByBugId(bugId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/updatecommentbyusername")
	public String updateCommentByUserId(@RequestBody Comment comment) {
		Comment commenttoUpdate = commentService.updateCommentByUserId(comment.getBugId(), comment.getBody(), LocalDateTime.now(), comment.getUserId());
		return commenttoUpdate.toString();
	}
	

	@RequestMapping(method = RequestMethod.PUT, value="/updatecommentbybugid")
	public String updateCommentByBugId(@RequestBody Comment comment) {
		Comment commenttoUpdate = commentService.updateCommentByBugId(comment.getBugId(), comment.getBody(), LocalDateTime.now(), comment.getUserId());
		return commenttoUpdate.toString();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deletecommentbybugid/{userName}")
	public String deleteCommentByBugId(@PathVariable String bugId) {
		commentService.deleteCommentByBugId(bugId);
		return "Deleted Bug with Bug Id:" + bugId;
	}
	
	@RequestMapping("/deleteallcomments")
	public String deleteAll() {
		commentService.deleteAll();
		return "Deleted all Comments";
	}
	
	
	
}
