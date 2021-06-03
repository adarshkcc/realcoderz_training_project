
  package com.books.dao;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import com.books.model.Author;
  
  public interface AuthorDAO extends JpaRepository<Author, Integer> {
   // findAuthorByAuthorName(String name);
  }
 