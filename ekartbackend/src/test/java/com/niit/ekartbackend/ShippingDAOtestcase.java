package com.niit.ekartbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ekartbackend.dao.ShippingDAO;
import com.niit.ekartbackend.domain.Shipping;

public class ShippingDAOtestcase {

	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static ShippingDAO  shippingDAO;
	@Autowired static Shipping shipping;
	
	@BeforeClass
	public static void initialize(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ekartbackend");
		context.refresh();
		
		//get the userDAO from context
				shippingDAO =  (ShippingDAO) context.getBean("ShippingDAO");
				
				//get the user from context
				
				shipping = (Shipping)context.getBean("shipping");
	}
	
	@Test
	public void createProductDAOTestCase()
	{
		
		shipping.setName("analog");
		shipping.setAddress("4,townroad,erode");
		shipping.setCitycode("638011");
		shipping.setPhone("999999999");
		shipping.setEmail("ship@gmail.com");
		
		boolean flag =  shippingDAO.save(shipping);
		assertEquals("createShippingDAOTestCase",true,flag);
		
	}
	
}
