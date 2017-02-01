package com.babynator.restserver;

import java.sql.Date;

public class Baby {
	//POJO lié à la table
	private int id, id_user;
	private Date birthday;
    private String name;
    private String gender;
    
       
	public Baby() {
		super();
	}
	public Baby(int id, Date birthday, String name, String gender, int id_user) {
		super();
		this.id = id;
		this.birthday = birthday;
		this.name = name;
		this.gender = gender;
		this.id_user = id_user;
	}
	
	@Override
	public String toString() {
		return "Baby [id=" + id + ", birthday=" + birthday.toString() + ", name=" + name + 
				", gender "+ gender +", id_user= "+id_user+"]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_User() {
		return id_user;
	}
	public void setId_User(int id_user) {
		this.id = id_user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name =  name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender =  gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday =  birthday;
	}
}
