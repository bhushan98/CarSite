package com.bhushan.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "carseq", initialValue = 10000, sequenceName = "car_seq", allocationSize = 1)
@NamedQuery(name = "getAll", query = "SELECT * FROM Car")
@NamedQuery(name = "byPrice", query = "SELECT c FROM Car c WHERE c.price BETWEEN :min AND :max")
@NamedQuery(name = "byName", query = "SELECT c FROM Car c WHERE c.name EQUALS :name")
@NamedQuery(name = "byModelNumber", query = "SELECT c FROM Car c WHERE c.modelNumber EQUALS :modelNumber")
@NamedQuery(name = "byRating", query = "SELECT c FROM Car c WHERE c.rating EQUALS :rating")
public class Car {
	
	@Id
	@GeneratedValue(generator = "carseq")
	private int id;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 20)
	private String modelNumber;
	
	@Column(length = 20)
	private String description;
	
	private double price;
	
	private double rating;
	
	private List<String> images;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	
}
