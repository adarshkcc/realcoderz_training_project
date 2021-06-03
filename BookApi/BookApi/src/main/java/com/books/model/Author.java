package com.books.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int author_id;
	private String author_name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id",nullable=false)
	private List<Books> books;
private int stock;
	


	public Author(int author_id, String author_name, List<Books> books, int stock) {
	super();
	this.author_id = author_id;
	this.author_name = author_name;
	this.books = books;
	this.stock = stock;
}



	public int getAuthor_id() {
	return author_id;
}



public void setAuthor_id(int author_id) {
	this.author_id = author_id;
}



public String getAuthor_name() {
	return author_name;
}



public void setAuthor_name(String author_name) {
	this.author_name = author_name;
}



public List<Books> getBooks() {
	return books;
}



public void setBooks(List<Books> books) {
	this.books = books;
}



public int getStock() {
	return stock;
}



public void setStock(int stock) {
	this.stock = stock;
}



	public Author() {
		super();
	}

}