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
    private String picture;
    @JsonIgnore
    private double weight;
    @JsonIgnore
    private double length;   
    
       
	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
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

	public Baby(int id, int id_user, String birthday, String name, String gender, double weight, double length, String picture) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.birthday = birthday;
		this.name = name;
		this.gender = gender;
		this.weight = weight;
		this.length = length;
		this.picture = picture;
	}


	@Override
	public String toString() {
		return "Baby [id=" + id + ", id_user=" + id_user + ", birthday=" + birthday + ", name=" + name + ", gender="
				+ gender + ", weight=" + weight + ", length=" + length + ", picture= "+ picture+" ]";
	}


	public Baby(int id, int id_user, String birthday, String name, String gender, String picture) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.birthday = birthday;
		this.name = name;
		this.gender = gender;
		this.picture = picture;
		this.weight=0;
		this.length = 0;
	}


	public String getPicture() {
		return this.picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}

}
