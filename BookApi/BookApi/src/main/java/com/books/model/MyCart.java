package com.books.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyCart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private double price;
	private String bookImage;
	private String pdf;
	
	
	public MyCart() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getBookImage() {
		return bookImage;
	}


	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}


	public String getPdf() {
		return pdf;
	}


	public void setPdf(String pdf) {
		this.pdf = pdf;
	}


	public MyCart(int id, String title, double price, String bookImage, String pdf) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.bookImage = bookImage;
		this.pdf = pdf;
	}
	
	
	
}
