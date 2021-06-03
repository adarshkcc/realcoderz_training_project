package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.books.dao.MyCartDAO;
import com.books.model.MyCart;
import com.books.service.MyCartServices;


@RestController
public class CartController {
	
	@Autowired
	private MyCartServices myCartService;
	
	@PostMapping("/addToCart")
	public MyCart addBooksToCart(@RequestBody MyCart myCart)
	{
		return myCartService.addToCart(myCart);
	}
	
	
	@GetMapping("/myCart")
		public List<MyCart> getCartList()
	{
		return  myCartService.getCartList();
	}
	
	
	@DeleteMapping("/myCart/{id}")
	public void deleteCartItem(@PathVariable("id") String id)
	{
		System.out.println("yaha p toh aaya h flow");
		myCartService.deleteCartItem(Integer.parseInt(id));
	}
	
	
	@GetMapping("/myCart/removeAll")
	public List<MyCart>  removeAllCartItem()
{
	return myCartService.removeAllCartItem();
}
}
