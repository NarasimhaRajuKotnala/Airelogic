package com.airelogic.bugtracker.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {
	
	@Id
	private String id;
	private String bugId;
	private String body;
	private LocalDateTime timestamp;
	private String userId;
	
	public Comment(String bugId, String body, LocalDateTime timestamp, String userId) {
		super();
		this.bugId = bugId;
		this.body = body;
		this.timestamp = timestamp;
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBugId() {
		return bugId;
	}

	public void setBugId(String bugId) {
		this.bugId = bugId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", bugId=" + bugId + ", body=" + body + ", timestamp=" + timestamp + ", userId="
				+ userId + "]";
	}
	
	
	
	
	
	

}
