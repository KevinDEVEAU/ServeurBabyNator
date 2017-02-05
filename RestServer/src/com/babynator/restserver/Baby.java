package com.babynator.restserver;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Baby {
	//POJO lié à la table
	private int id;
	private int id_user;
	private String birthday;
    private String name;
    private String gender;
    @JsonIgnore
    private int weight;
    @JsonIgnore
    private int length;
    
    
       
	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


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
	



	public Baby(int id, int id_user, String birthday, String name, String gender, int weight, int length) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.birthday = birthday;
		this.name = name;
		this.gender = gender;
		this.weight = weight;
		this.length = length;
	}


	@Override
	public String toString() {
		return "Baby [id=" + id + ", id_user=" + id_user + ", birthday=" + birthday + ", name=" + name + ", gender="
				+ gender + ", weight=" + weight + ", length=" + length + "]";
	}


	public Baby(int id, int id_user, String birthday, String name, String gender) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.birthday = birthday;
		this.name = name;
		this.gender = gender;
		this.weight=0;
		this.length = 0;
	}

}
