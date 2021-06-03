package com.books.service;

import java.util.List;

import com.books.model.User;

public interface UserService {
      public User registerUser(User user);
      public List<User> login();
      
}
