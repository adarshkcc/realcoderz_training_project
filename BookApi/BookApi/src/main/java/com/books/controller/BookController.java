package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.Exception.IdNotFoundException;
import com.books.dao.BooksDAO;
import com.books.model.Author;
import com.books.model.Books;
import com.books.service.Admin_services;

@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	private Admin_services adminService;

	@Autowired
	private BooksDAO booksDAO;

	@PostMapping("/addNewBook")
	public boolean addBooks(@RequestBody Author author) {
		return adminService.addBookDetails(author);

	}

	@GetMapping("/books")
	public List<Author> getBooks() {

		return adminService.getAllBooks();
	}

	@PutMapping("/addBookinExistingAuthor")
	public Author updateExistingAuthorBooks(@RequestBody Author auhtor) {
		return adminService.addNewBook(auhtor);
	}

	@GetMapping("/book/{name}")
	public Books getBookByTitle(@PathVariable String name) {

		return booksDAO.findBooksByTitle(name);
	}
	@PutMapping("/book/{id}")
	public void updateBook(@RequestBody Books book,@PathVariable String id) {
		System.out.println(id);
		// this.adminService.updateBookprice(Long.parseLong(id),Double.parseDouble(price));
	}


	@DeleteMapping("/book/{id}")
	public boolean deleteBook(@PathVariable("id") String id) {
		boolean flag= this.adminService.removeBook(Long.parseLong(id));
		try {
			if(flag==false)
			{
				throw new IdNotFoundException("Id not found");
			}
			else {
				return flag;
			}
		}
			catch(IdNotFoundException e)
			{
				System.out.println(e.getMessage());
				return flag;
			}
		
	}

}