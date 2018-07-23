package com.airelogic.bugtracker.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airelogic.bugtracker.models.Comment;
import com.airelogic.bugtracker.repositories.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	
	//Create operation
	public Comment addComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	
	//Retrieve operation
	public List<Comment> getAll(){
		return commentRepository.findAll();
	}
	
	public Comment getByUserName(String userId) {
		return commentRepository.findByUserId(userId);
	}
	
	public Comment getByBugId(String bugId) {
		return commentRepository.findByBugId(bugId);
	}
	
	public Comment updateCommentByBugId(String bugId, String body, LocalDateTime timestamp, String userId) {	
		Comment comment = commentRepository.findByBugId(bugId);
				comment.setBody(body);
				comment.setUserId(userId);
				comment.setTimestamp(LocalDateTime.now());
		return commentRepository.save(comment);
	}
	
	public Comment updateCommentByUserId(String bugId, String body, LocalDateTime timestamp, String userId) {		
		Comment comment = commentRepository.findByUserId(userId);
				comment.setBody(body);
				comment.setTimestamp(LocalDateTime.now());
				comment.setUserId(userId);
		return commentRepository.save(comment);
	}
	
	
	//Delete operation
	public void deleteAll() {
		commentRepository.deleteAll();
	}
	
	//delete user by BugId
	public void deleteCommentByBugId(String bugId) {
		Comment comment = commentRepository.findByBugId(bugId);
				commentRepository.delete(comment);
	}
	
	//delete user by UserId
	public void deleteCommentByUserId(String userId) {
		Comment comment = commentRepository.findByBugId(userId);
				commentRepository.delete(comment);
	}


}
