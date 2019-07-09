package com.schoolapp.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Alerts {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String categories;
	private String notification;
	private String notificationtitle;
	private String createdBy;
	private Date createdOn;
	
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getCategories() {
		return categories;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setNotificationtitle(String notificationtitle) {
		this.notificationtitle = notificationtitle;
	}
	public String getNotificationtitle() {
		return notificationtitle;
	}
}
