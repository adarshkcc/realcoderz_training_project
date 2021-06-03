package com.books;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.books.model.User;
import com.books.repository.UserServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@Transactional
class UserTest {

	@Autowired
	private UserServiceImpl userServiceImpl;
	@Test
	void testRegisterUser() {
		User user=new User();
		user.setId(1);
		user.setContact("9990213232");
		user.setEmail("man@gamil.com");
		user.setPassword("asjssa");
		user.setUserName("manuj");
		userServiceImpl.registerUser(user);
	}

	@Test
	void testLogin() {
		User user=new User();
		user.setPassword("man@123");
		user.setUserName("manuj");
		userServiceImpl.login();
		Assert.assertEquals("manuj",user.getUserName());
		Assert.assertEquals("man@123",user.getPassword());

	}

}
