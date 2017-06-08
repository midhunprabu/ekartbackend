package com.niit.ekartbackend.config;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ekartbackend.domain.Billing;
import com.niit.ekartbackend.domain.Category;
import com.niit.ekartbackend.domain.Product;
import com.niit.ekartbackend.domain.Role;
import com.niit.ekartbackend.domain.Shippingaddress;
import com.niit.ekartbackend.domain.Supplier;
import com.niit.ekartbackend.domain.User;
import com.niit.ekartbackend.dao.CartDAO;
import com.niit.ekartbackend.daoimpl.CartDAOImpl;
import com.niit.ekartbackend.domain.Cart;
import com.niit.ekartbackend.dao.BillingDAO;
import com.niit.ekartbackend.dao.CategoryDAO;
import com.niit.ekartbackend.dao.ProductDAO;
import com.niit.ekartbackend.dao.RoleDAO;
import com.niit.ekartbackend.dao.ShippingaddressDAO;
import com.niit.ekartbackend.dao.SupplierDAO;
import com.niit.ekartbackend.dao.UserDAO;
import com.niit.ekartbackend.daoimpl.BillingDAOImpl;
import com.niit.ekartbackend.daoimpl.CategoryDAOImpl;
import com.niit.ekartbackend.daoimpl.ProductDAOImpl;
import com.niit.ekartbackend.daoimpl.RoleDAOImpl;
import com.niit.ekartbackend.daoimpl.ShippingaddressDAOImpl;
import com.niit.ekartbackend.daoimpl.SupplierDAOImpl;
import com.niit.ekartbackend.daoimpl.UserDAOImpl;

@Configuration
@ComponentScan("com.niit.ekartbackend")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Autowired
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUrl("jdbc:h2:tcp://localhost/~/ekart");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Shippingaddress.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Role.class);
		sessionBuilder.addAnnotatedClass(Billing.class);
		// add all other domain object classes

		// Instead of adding individua domain objects to sessionBuilder.
		// you can add all the domain objects using single statement
		// sessionBuilder.scanPackages("com.niit.ekartbackend");

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired(required=true)
	@Bean(name = "userDAO")
	public UserDAO getuserDAO(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}
	

	@Autowired(required=true)
	@Bean(name = "categoryDAO")
	public CategoryDAO getcategoryDAO(SessionFactory sessionFactory) {
		return new CategoryDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name = "productDAO")
	public ProductDAO getproductDAO(SessionFactory sessionFactory) {
		return new ProductDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name = "SupplierDAO")
	public SupplierDAO getsupplierDAO(SessionFactory sessionFactory) {
		return new SupplierDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name = "ShippingaddressDAO")
	public ShippingaddressDAO getshippingDAO(SessionFactory sessionFactory) {
		return new ShippingaddressDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name = "CartDAO")
	public CartDAO getcartDAO(SessionFactory sessionFactory) {
		return new CartDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name = "RoleDAO")
	public RoleDAO getroleDAO(SessionFactory sessionFactory) {
		return new RoleDAOImpl(sessionFactory);
	}
	
	@Autowired(required=true)
	@Bean(name = "BillingDAO")
	public BillingDAO getbillingDAO(SessionFactory sessionFactory) {
		return new BillingDAOImpl(sessionFactory);
	}
	
}
