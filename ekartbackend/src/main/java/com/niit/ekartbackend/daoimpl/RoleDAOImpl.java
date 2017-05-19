package com.niit.ekartbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartbackend.dao.RoleDAO;
import com.niit.ekartbackend.domain.Role;


@Repository("RoleDAO")
@Transactional
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public RoleDAOImpl(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}
	
	public void save(Role role) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(role);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> list() {

		return  sessionFactory.getCurrentSession().createQuery("from role").list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public Role get(String id) {
		return 	(Role)  sessionFactory.getCurrentSession().get(Role.class, id);
	}

	public boolean update(Role role) {
		try
		{
		sessionFactory.getCurrentSession().update(role);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Role getByEmailId(String email) {
		String hql = "from Role where email ='"+ email +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Role> listRole = (List<Role>) query.list();
		
		if (listRole != null && !listRole.isEmpty()){
			return listRole.get(0);
		}
		return null;

	}
	
}
