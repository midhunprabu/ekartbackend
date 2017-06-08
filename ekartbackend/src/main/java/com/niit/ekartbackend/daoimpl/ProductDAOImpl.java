package com.niit.ekartbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartbackend.dao.ProductDAO;
import com.niit.ekartbackend.domain.Product;
import com.niit.ekartbackend.domain.User;

@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	
	public boolean saveOrUpdate(Product product) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*public boolean update(Product product) {
		try
		{
		sessionFactory.getCurrentSession().update(product);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}*/

	@SuppressWarnings("unchecked")
	public List<Product> list() {

		return  sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	

	public Product get(String productid) {
		
		return 	(Product)  sessionFactory.getCurrentSession().get(Product.class, productid);
		
	}
	public User getById(String id) {
		String hql = "from User where email ='"+ id +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()){
			return listUser.get(0);
		}
		return null;
		
	}

	public void delete(String productid) {
		Product productToDelete = new Product();
		productToDelete.setProductid(productid);
sessionFactory.getCurrentSession().delete(productToDelete);
		
	}


	public void save(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}


	public Product getByProductid(String productid) {
		String hql = "from Product where productId ='" + productid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) (query).list();

		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		return null;
	}


	public List<Product> list(String categoryName) {
		String hql = "from Product where category ='" + categoryName + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>) query.list();

		return list;  
	}




	





	
}
