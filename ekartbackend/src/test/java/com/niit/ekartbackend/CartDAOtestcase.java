package com.niit.ekartbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ekartbackend.dao.MycartDAO;
import com.niit.ekartbackend.domain.Cart;

public class CartDAOtestcase {

	
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static MycartDAO  mycartDAO;
	@Autowired static Cart mycart;
	
	@BeforeClass
	public static void initialize(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ekartbackend");
		context.refresh();
		
		//get the userDAO from context
				mycartDAO =  (MycartDAO) context.getBean("MycartDAO");
				
				//get the user from context
				
				mycart = (Cart)context.getBean("mycart");
	}
	
	@Test
	public void createMycartDAOTestCase()
	{
		
		mycart.setName("analog");
		mycart.setDate("men");
		mycart.setPrice("titan");
		mycart.setQuantity("3350");
		mycart.setTotal("10000");
		
		boolean flag =  mycartDAO.save(mycart);
		assertEquals("createMycartDAOTestCase",true,flag);
		
	}
	
}
