package com.niit.ekartbackend;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.ekartbackend.dao.SupplierDAO;
import com.niit.ekartbackend.domain.Supplier;

public class SupplierDAOtestcase {


	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static SupplierDAO  supplierDAO;
	@Autowired static Supplier supplier;
	
	@BeforeClass
	public static void initialize(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ekartbackend");
		context.refresh();
		//get the userDAO from context
		supplierDAO =  (SupplierDAO) context.getBean("SupplierDAO");
		
		//get the user from context
		
		supplier = (Supplier)context.getBean("supplier");
}
		
	
	@Test
	public void createSupplierDAOTestCase()
	{
		supplier.setEmail("ram@gmail.com");
		supplier.setName("ram");
		supplier.setAddress("4,sampathnagar,erode"); 
		supplier.setPhone("9999999999");
		
		
		boolean flag =  supplierDAO.saveOrUpdate(supplier);
		assertEquals("createSupplierDAOTestCase",true,flag);
		
	}
	
	}
	

