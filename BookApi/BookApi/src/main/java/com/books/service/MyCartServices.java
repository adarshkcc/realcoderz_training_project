package com.books.service;

import java.util.List;

import com.books.model.MyCart;

public interface MyCartServices {

	MyCart addToCart(MyCart myCart);

	List<MyCart> getCartList();

	void deleteCartItem(int id);

	List<MyCart> removeAllCartItem();

}
