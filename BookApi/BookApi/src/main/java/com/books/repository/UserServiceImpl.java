package com.books.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.UserDAO;
import com.books.model.User;
import com.books.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User registerUser(User user) {
		userDAO.save(user);
		return user;
	}

	@Override
	public List<User> login() {
		return userDAO.findAll();
	}

}
