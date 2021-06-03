package com.books.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.books.Exception.InvalidPriceException;

@Entity
@Table(name = "books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String title;
	@Column(name = "description")
	private String desc;
	@Column(name = "published_date")
	private String date;

	private String bookUrl;
	private double price;
	private double rating;
	private String category;
	private String pdf;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBookUrl() {
		return bookUrl;
	}

	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
	}

	public double getPrice() {
		return price;
	}

	// custom exception are handeled here in case of -ve price
	public void setPrice(double price) {
		try {
			if(price<0)
			{
				throw new InvalidPriceException("enter the valid price "+price);
			}
			else {
		
		this.price = price;
		}
		}
			catch(InvalidPriceException e)
			{
				this.price=price;
				System.out.println(e.getMessage());
			}
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}



	public Books(long id, String title, String desc, String date, String bookUrl, double price, double rating,
			String category, String pdf)  {
		super();
		
		
		
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.date = date;
		this.bookUrl = bookUrl;
		this.price = price;
		this.rating = rating;
		this.category = category;
		this.pdf = pdf;
			}
		
	

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Books() {
	}

}