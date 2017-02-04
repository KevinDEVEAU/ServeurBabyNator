package com.babynator.restserver;

import java.sql.Date;

public class Baby {
	//POJO lié à la table
	private int id;
	private int id_user;
	private String birthday;
    private String name;
    private String gender;
    
       
	public Baby() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Baby [id=" + id + ", id_user=" + id_user + ", birthday=" + birthday + ", name=" + name + ", gender="
				+ gender + "]";
	}


	public Baby(int id, int id_user, String birthday, String name, String gender) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.birthday = birthday;
		this.name = name;
		this.gender = gender;
	}

}
