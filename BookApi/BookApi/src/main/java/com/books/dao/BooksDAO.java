package com.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.books.model.Books;

public interface BooksDAO extends JpaRepository<Books, Long> {
	Books findBooksByTitle(String name);
	long deleteByTitle(String title);
	@Modifying
	@Query("update Books book set book.price = :price where book.id = :id")
	void updatePrice(@Param(value = "id") long id, @Param(value = "price") Double price);
}
