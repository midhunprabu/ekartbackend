package com.niit.ekartbackend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ekartbackend.dao.RoleDAO;
import com.niit.ekartbackend.dao.UserDAO;
import com.niit.ekartbackend.domain.Role;
import com.niit.ekartbackend.domain.User;

public class UserDAOtestcase {

	
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static UserDAO  userDAO;
	
	@Autowired  static User user;
	
	@Autowired
	static RoleDAO roleDAO;

	@Autowired
	static Role role;
	
	//The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case
	 * and will execute only once
	 */
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ekartbackend");
		context.refresh();
		
		//get the userDAO from context
		userDAO =  (UserDAO) context.getBean("UserDAO");
		roleDAO =  (RoleDAO) context.getBean("RoleDAO");
		//get the user from context
		
		user = (User)context.getBean("user");
		role = (Role)context.getBean("role");
	}
	
	@Test
	public void createUserDAOTestCase()
	{
		
		user.setName("indhumathi");
		user.setPassword("indhumathi");
		user.setConfirm_password("indhumathi");
		user.setPhone_number("46646464");
		user.setEmail("indhumathi@gmail");
		user.setAddress("4,sampathnagar,erode");
		
	
		
		role.setName("indhumathi");
		role.setRole("ADMIN");
		role.setEmail("indhumathi@gmail");
		
		user.setRole(role);
		role.setUser(user);

		roleDAO.save(role);

		userDAO.save(user);
		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		//assertEquals("createUserDAOTestCase",true,flag);
		
	}
	

	
}











