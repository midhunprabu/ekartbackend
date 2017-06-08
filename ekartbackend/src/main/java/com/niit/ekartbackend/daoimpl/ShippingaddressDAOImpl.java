package com.niit.ekartbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartbackend.dao.ShippingaddressDAO;
import com.niit.ekartbackend.domain.Shippingaddress;

@Transactional
@Repository("ShippingaddressDAO")
public class ShippingaddressDAOImpl implements ShippingaddressDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public ShippingaddressDAOImpl (SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Shippingaddress> list() {
		return sessionFactory.getCurrentSession().createQuery("from Shippingaddress").list();

	}
	public List<Shippingaddress> list(String email) {
		String hql = "from Shippingaddress where email='" + email + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Shippingaddress> list = (List<Shippingaddress>) query.list();
		
		return list;
	}
	public Shippingaddress getByShippingAddress(String address) {
		String hql = "from Shippingaddress where address ='" + address + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;
	}
	public Shippingaddress getByName(String name) {
		String hql = "from Shippingaddress where name='" + name + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;
	}
	public void saveOrUpdate(Shippingaddress address) {
		sessionFactory.getCurrentSession().saveOrUpdate(address);
		
	}
	public void delete(int sid) {
		Shippingaddress shippingaddressToDelete = new Shippingaddress();
		shippingaddressToDelete.setSid(sid);
		sessionFactory.getCurrentSession().delete(shippingaddressToDelete);

		
	}
	public Shippingaddress getBySid(int sid) {
		String hql = "from Shippingaddress where sid='" + sid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;	
	}
	

	
}