package com.books.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.AuthorDAO;
import com.books.dao.BooksDAO;
import com.books.model.Author;
import com.books.model.Books;
import com.books.service.Admin_services;
@Service
public class AdminServiceimpl implements Admin_services {

	@Autowired
	private AuthorDAO authorDAO;
	
	@Autowired
	private BooksDAO bookDAO;

	// custom exception are handeled here in case of -ve price
	@Override
	public boolean addBookDetails(Author author) {
		if(author.getBooks().get(0).getPrice()<0)
		{
			System.out.println(author.getBooks().get(0).getPrice());
			return false;
		}
		else {
		authorDAO.save(author);
		return true;
		}

	}

	@Override
	public List<Author> getAllBooks() {
		return authorDAO.findAll();
	}

	@Override
	public Author addNewBook(Author author) {
		
		Optional<Author> author1=authorDAO.findById(author.getAuthor_id());
		
		Author foundAuthor=author1.get();
		
		foundAuthor.setAuthor_name(author.getAuthor_name());
		List<Books> booklist=new ArrayList<Books>();
		
		for(Books book:author.getBooks())
		{
		
			
				Books b=new Books();
				b.setTitle(book.getTitle());
				b.setBookUrl(book.getBookUrl());
				b.setCategory(book.getCategory());
				b.setDate(book.getDate());
				b.setDesc(book.getDesc());
				b.setId(book.getId());
				b.setPrice(book.getPrice());
				b.setRating(book.getRating());
				b.setPdf(book.getPdf());
				
				booklist.add(b);
			
			
		}
		foundAuthor.setBooks(booklist);
		foundAuthor.setStock(author.getStock()+booklist.size());
		
			return authorDAO.save(foundAuthor);
		
		
		
		
	}

	@Override
	public boolean removeBook(long id) {
		//bookDAO.deleteByTitle(name);
	boolean flag=	bookDAO.existsById(id);
	if(flag) {
		Books b=bookDAO.getOne(id);
		bookDAO.delete(b);
		return true;
	}
		return false;
	}

	@Override
	public void updateBookprice(long id, double price) {
		bookDAO.updatePrice(id, price);
		
	}
}