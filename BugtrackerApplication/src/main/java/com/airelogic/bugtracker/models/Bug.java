package com.airelogic.bugtracker.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bug {
	
	@Id
	private String id;
	private String title;
	private String description;
	private LocalDateTime timestamp;
	private LocalDate dueDate;
	private String assignedTo;
	private String userId;
	private String[] viewedBy;
	private String[] watchers;
	private String priority;
	private String[] tags;
	private String[] comments;
	private String status;
	
	public Bug() {
		
	}
	
	public Bug(String id, String title, String description, LocalDateTime timestamp, LocalDate dueDate,
			String assignedTo, String userId, String[] viewedBy, String[] watchers, String priority, String[] tags,
			String[] comments, String status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.timestamp = timestamp;
		this.dueDate = dueDate;
		this.assignedTo = assignedTo;
		this.userId = userId;
		this.viewedBy = viewedBy;
		this.watchers = watchers;
		this.priority = priority;
		this.tags = tags;
		this.comments = comments;
		this.status = status;
	}
	
	public Bug(String title, String description, LocalDateTime timestamp, LocalDate dueDate, String assignedTo,
			String userId, String[] viewedBy, String[] watchers, String priority, String[] tags, String[] comments,
			String status) {
		super();
		this.title = title;
		this.description = description;
		this.timestamp = timestamp;
		this.dueDate = dueDate;
		this.assignedTo = assignedTo;
		this.userId = userId;
		this.viewedBy = viewedBy;
		this.watchers = watchers;
		this.priority = priority;
		this.tags = tags;
		this.comments = comments;
		this.status = status;
	}




	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String[] getViewedBy() {
		return viewedBy;
	}
	public void setViewedBy(String[] viewedBy) {
		this.viewedBy = viewedBy;
	}
	public String[] getWatchers() {
		return watchers;
	}
	public void setWatchers(String[] watchers) {
		this.watchers = watchers;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public String[] getComments() {
		return comments;
	}
	public void setComments(String[] comments) {
		this.comments = comments;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Bug [id=" + id + ", title=" + title + ", description=" + description + ", timestamp=" + timestamp
				+ ", dueDate=" + dueDate + ", assignedTo=" + assignedTo + ", userId=" + userId + ", viewedBy="
				+ Arrays.toString(viewedBy) + ", watchers=" + Arrays.toString(watchers) + ", priority=" + priority
				+ ", tags=" + Arrays.toString(tags) + ", comments=" + Arrays.toString(comments) + ", status=" + status
				+ "]";
	}
	
	
	
	
	

}
