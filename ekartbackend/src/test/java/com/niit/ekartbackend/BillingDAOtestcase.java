package com.niit.ekartbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ekartbackend.domain.Billing;
import com.niit.ekartbackend.dao.BillingDAO;

public class BillingDAOtestcase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static BillingDAO billingDAO;
	@Autowired
	static Billing billing;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ekartbackend");
		context.refresh();

		// get the userDAO from context
		billingDAO = (BillingDAO) context.getBean("BillingDAO");

		// get the user from context

		billing = (Billing) context.getBean("billing");

	}

	@Test
	public void createBillingDAOTestCase() {

		billing.setName("women");
		billing.setAddress("male");
		billing.setCitycode("male");
		billing.setPhone("male");
		billing.setEmail("male");
		boolean flag = billingDAO.save(billing);
		assertEquals("createBillingDAOTestCase", true, flag);

	}

}
