package com.books;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.books.model.Author;
import com.books.model.Books;
import com.books.repository.AdminServiceimpl;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@Transactional
class AdminTest {

	@Autowired
	private AdminServiceimpl admin;
	
	@Test
	void testAddBookDetails() {
Books books=new Books();
books.setId(1);
books.setBookUrl("asasa");
books.setCategory("action");
books.setDate("12-2-2102");
books.setDesc("assdfs");
books.setPdf("asssa.pdf");
books.setPrice(1200.00);
books.setRating(2);
books.setTitle("sad");
Author author=new Author();
author.setAuthor_id(1);
author.setAuthor_name("jony dil");
author.setStock(2);
ArrayList<Books> book = new ArrayList<Books>();
book.add(books);

author.setBooks(book);
admin.addBookDetails(author);

		
	}


	@Test
	void testAddNewBook() {

		Author author=new Author();
		Books books=new Books();
		books.setId(1);
		books.setBookUrl("asasa");
		books.setCategory("action");
		books.setDate("12-2-2102");
		books.setDesc("assdfs");
		books.setPdf("asssa.pdf");
		books.setPrice(1200.00);
		books.setRating(2);
		books.setTitle("sad");
		author.setAuthor_id(1);
		author.setAuthor_name("jony dil");
		author.setStock(2);
		ArrayList<Books> book = new ArrayList<Books>();
		book.add(books);

		author.setBooks(book);
		admin.addBookDetails(author);

		
	}

	@Test
	void testRemoveBook() {
		Books books=new Books();
		books.setId(1);
		books.setBookUrl("asasa");
		books.setCategory("action");
		books.setDate("12-2-2102");
		books.setDesc("assdfs");
		books.setPdf("asssa.pdf");
		books.setPrice(1200.00);
		books.setRating(2);
		books.setTitle("sad");
		admin.removeBook(1);
	}

	@Test
	void testUpdateBookprice() {

		admin.updateBookprice(1, 1400);
	}

}
