package com.niit.ekartbackend.dao;

import java.util.List;

import com.niit.ekartbackend.domain.Role;

public interface RoleDAO {


	public  void save(Role role);
	public boolean update(Role role);
    
	public List<Role>     list();
	public Role getByEmailId(String name);
	
}
