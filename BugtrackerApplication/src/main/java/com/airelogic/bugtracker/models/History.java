package com.airelogic.bugtracker.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class History {
	
	@Id
	private String id;
	private String bugId;
	private String userId;
	private String action;
	private LocalDateTime timestamp;
	
	public History(String bugId, String userId, String action, LocalDateTime timestamp) {
		super();
		this.bugId = bugId;
		this.userId = userId;
		this.action = action;
		this.timestamp = timestamp;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", bugId=" + bugId + ", userId=" + userId + ", action=" + action + ", timestamp="
				+ timestamp + "]";
	}
	
	

}
