package com.niit.ekartbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ekartbackend.dao.ProductDAO;
import com.niit.ekartbackend.domain.Product;

public class ProductDAOtestcase {

	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static ProductDAO  productDAO;
	@Autowired static Product product;
	
	@BeforeClass
	public static void initialize(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ekartbackend");
		context.refresh();
		
		//get the userDAO from context
				productDAO =  (ProductDAO) context.getBean("ProductDAO");
				
				//get the user from context
				
				product = (Product)context.getBean("product");
	}
	
	@Test
	public void createProductDAOTestCase()
	{
		
		product.setName("analog");
		product.setCategory("men");
		product.setBrand("titan");
		product.setPrice("3350");
		product.setColor("black");
		
		boolean flag =  productDAO.saveOrUpdate(product);
		assertEquals("createProductDAOTestCase",true,flag);
		
	}
		
	}
	

