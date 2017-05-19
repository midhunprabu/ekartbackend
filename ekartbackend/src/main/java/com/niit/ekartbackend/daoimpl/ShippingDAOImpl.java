package com.niit.ekartbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartbackend.dao.ShippingDAO;
import com.niit.ekartbackend.domain.Shipping;

@Repository("ShippingDAO")
@Transactional
public class ShippingDAOImpl implements ShippingDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ShippingDAOImpl(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}


	public boolean save(Shipping shipping) {
		try
		{
		sessionFactory.getCurrentSession().save(shipping);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Shipping shipping) {
		try
		{
		sessionFactory.getCurrentSession().update(shipping);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Shipping> list() {

		return  sessionFactory.getCurrentSession().createQuery("from product").list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public Shipping get(String id) {
		return 	(Shipping)  sessionFactory.getCurrentSession().get(Shipping.class, id);
	}
	
}
