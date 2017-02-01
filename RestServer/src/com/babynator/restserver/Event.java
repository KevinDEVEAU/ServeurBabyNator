package com.babynator.restserver;

import java.sql.Date;

public class Event {
	//POJO lié à la table
	private int id;
	private String current_date;
    private String title;
    private String description;
    private int id_user;  
	
	public Event(int id, String current_date, String title, String description, int id_user) {
		super();
		this.id = id;
		this.current_date = current_date;
		this.title = title;
		this.description = description;
		this.id_user = id_user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurrent_date() {
		return current_date;
	}
	public void setCurrent_date(String current_date) {
		this.current_date = current_date;
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
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", current_date=" + current_date + ", title=" + title + ", description="
				+ description + ", id_user=" + id_user + "]";
	}
	public Event() {
		super();
	}	
}
