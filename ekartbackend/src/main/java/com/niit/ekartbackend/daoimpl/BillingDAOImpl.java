package com.niit.ekartbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartbackend.domain.Billing;
import com.niit.ekartbackend.domain.Category;
import com.niit.ekartbackend.dao.BillingDAO;

@Repository("BillingDAO")
@Transactional
public class BillingDAOImpl implements BillingDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public BillingDAOImpl(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}

	public boolean save(Billing billing) {
		try
		{
		sessionFactory.getCurrentSession().save(billing);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Billing billing) {
		try
		{
		sessionFactory.getCurrentSession().update(billing);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Billing> list() {
		return  sessionFactory.getCurrentSession().createQuery("from Billing").list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Billing get(String id) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(Billing)  sessionFactory.getCurrentSession().get(Billing.class, id);
		
	}

	public boolean save(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return false;
	}
}
