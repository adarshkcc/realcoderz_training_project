package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.Exception.UserNotFound;
import com.books.dao.UserDAO;
import com.books.model.User;
import com.books.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserDAO user;

	@PostMapping("/login")
	public List<User> login() {

		return userService.login();
	}

	@PostMapping("/register")
	public User register(@RequestBody User user) {

		return userService.registerUser(user);

	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateAuthor(@PathVariable Long id, @RequestBody User registration) {
		User registration2 = user.findById(id).orElseThrow(() -> new UserNotFound("User not found"));
		registration2.setUserName(registration.getUserName());
		registration2.setEmail(registration.getEmail());
		registration2.setContact(registration.getContact());
		registration2.setPassword(registration.getPassword());
		User update = user.save(registration2);
		return ResponseEntity.ok(update);
	}

	/*
	 * @DeleteMapping("/removeRegsitration/{id}") public String
	 * removeAuthor(@PathVariable Long id) { registrationrepo.deleteById(id); return
	 * "removed the registration"; }
	 */

}