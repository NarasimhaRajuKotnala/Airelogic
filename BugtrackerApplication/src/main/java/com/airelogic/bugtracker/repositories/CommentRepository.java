package com.airelogic.bugtracker.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airelogic.bugtracker.models.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
	
	public Comment findByUserId(String userId);
	public Comment findByBugId(String bugId); 
	public void deleteCommentByUserId(String userId);
	public void deleteCommentByBugId(String bugId);
	
}
