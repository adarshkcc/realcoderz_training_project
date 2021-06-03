package com.books.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.MyCartDAO;
import com.books.model.MyCart;
import com.books.service.MyCartServices;

@Service
public class MyCartServicesImpl implements MyCartServices {

	@Autowired
	private MyCartDAO myCartDao;

	
	
	// adding an item to the cart
	@Override
	public MyCart addToCart(MyCart myCart) 
	{

		MyCart cart=myCartDao.save(myCart);
		System.out.println(cart);
		return cart;
	}
	
	// getting all the items added in cart
	@Override
	public List<MyCart> getCartList() 
	{
		
		return myCartDao.findAll();
	}
	
	//removing the items added in cart
	@Override
	public void deleteCartItem(int id) 
	{
		
	MyCart entity=	myCartDao.getOne(id);
try {
	myCartDao.delete(entity);
}catch(IllegalArgumentException e)
{
	System.out.println("nothing to delete");
}
	}

	// removing all the items added in cart after user logout.
	@Override
	public List<MyCart>  removeAllCartItem() {
		
		 myCartDao.deleteAll();
		 
		System.out.println("All the items has been removed after user logout");
		return myCartDao.findAll();
		
	}


}
