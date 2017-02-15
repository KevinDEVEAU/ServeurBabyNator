package com.babynator.restserver;

public class Data {

	private double weight;
	private double length;
	private int id_baby;
	private String current_date;
	
	@Override
	public String toString() {
		return "Data [weight=" + weight + ", length=" + length + ", id_baby=" + id_baby + ", current_date="
				+ current_date + "]";
	}
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
	public int getId_baby() {
		return id_baby;
	}
	public void setId_baby(int id_baby) {
		this.id_baby = id_baby;
	}
	public String getCurrent_date() {
		return current_date;
	}
	public void setCurrent_date(String current_date) {
		this.current_date = current_date;
	}
	public Data(double weight, double length, int id_baby, String current_date) {
		super();
		this.weight = weight;
		this.length = length;
		this.id_baby = id_baby;
		this.current_date = current_date;
	}
	public Data() {
		super();
	}
}
