package com.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.model.MyCart;

public interface MyCartDAO extends JpaRepository<MyCart, Integer>{

}
