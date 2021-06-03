package com.books;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.books.model.MyCart;
import com.books.repository.MyCartServicesImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@Transactional
class MyCartTest {

	
	@Autowired
	private MyCartServicesImpl myCartServicesImpl;

	@Test
	void testAddToCart() {
		MyCart myCart=new MyCart();
		myCart.setBookImage("kajalsaransh.jpg");
		myCart.setPrice(3444);
		myCart.setTitle("sad");
		myCartServicesImpl.addToCart(myCart);
		//Assert.assertNotNull(myCart);
		
	}

	@Test
	void testGetCartList() {

		MyCart myCart=new MyCart();
		myCart.setId(1);
		myCart.setTitle("action");
		myCart.setPrice(2400);
		myCart.setBookImage("lifeofpi.jpg");
	    myCartServicesImpl.getCartList();
	}

	@Test
	void testDeleteCartItem() {

	    myCartServicesImpl.deleteCartItem(19);
	}

}
