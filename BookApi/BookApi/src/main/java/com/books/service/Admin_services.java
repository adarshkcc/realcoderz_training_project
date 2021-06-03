package com.books.service;

import java.util.List;

import com.books.model.Author;



public interface Admin_services {
	/*
	 * public List<Books> getAllBooks();
	 * 
	 * public Books getBookByName(String name); public List<Books>
	 * getBooksByCategory(); public List<Books> getBooksByAuthor();
	 * 
	 * 
	 * 
	 * public Books modifyBook(Books book);
	 */
  
  public boolean addBookDetails(Author author);
  public List<Author> getAllBooks();
  public Author addNewBook(Author author); 
  public boolean removeBook(long id);
public void updateBookprice(long id, double price);
 
}
