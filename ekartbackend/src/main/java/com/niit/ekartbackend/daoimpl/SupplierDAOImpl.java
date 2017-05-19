package com.niit.ekartbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartbackend.dao.SupplierDAO;
import com.niit.ekartbackend.domain.Supplier;

	@Repository("SupplierDAO")
	@Transactional
	public class SupplierDAOImpl implements SupplierDAO {
		
		@Autowired
		private SessionFactory sessionFactory;
		
		public SupplierDAOImpl(SessionFactory sessionFactory)
		{
			this.setSessionFactory(sessionFactory);
		}
		
	
		@SuppressWarnings("unchecked")
		public List<Supplier> list(){
			
			return  sessionFactory.getCurrentSession().createQuery("from Supplier").list();
			
		}
		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		public Supplier get(String id) {
			return 	(Supplier)  sessionFactory.getCurrentSession().get(Supplier.class, id);
		}

		public boolean save(Supplier supplier) {
			try
			{
			sessionFactory.getCurrentSession().save(supplier);
			}catch (Exception e) {
				//if any excpetion comes during execute of try block, catch will excute
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public boolean update(Supplier supplier) {
			try
			{
			sessionFactory.getCurrentSession().update(supplier);
			}catch (Exception e) {
				//if any excpetion comes during execute of try block, catch will excute
				e.printStackTrace();
				return false;
			}
			return true;
		}


		public boolean save(@SuppressWarnings("rawtypes") java.util.function.Supplier supplier) {
			// TODO Auto-generated method stub
			return false;
		}


		public boolean update(@SuppressWarnings("rawtypes") java.util.function.Supplier supplier) {
			// TODO Auto-generated method stub
			return false;
		}
		
		public void delete(String id) {
			Supplier supplierToDelete = new Supplier();
			supplierToDelete.setId(id);
	sessionFactory.getCurrentSession().delete(supplierToDelete);
			
		}

	}

