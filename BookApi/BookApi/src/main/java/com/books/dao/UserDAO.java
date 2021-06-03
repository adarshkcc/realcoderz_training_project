package com.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.books.model.User;

public interface UserDAO extends JpaRepository<User, Long> {
User findUserById(long id);
	@Modifying
	@Query("update User u set u.email = :email where u.id = :id")
	void updated(@Param(value = "id") long id, @Param(value = "email") String email);

	

}
