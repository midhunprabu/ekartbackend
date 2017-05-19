package com.niit.ekartbackend.dao;

import java.util.List;

import com.niit.ekartbackend.domain.User;

public interface UserDAO {
	
	
	
	public  void save(User user);
	
	// update the user details  - update
	public boolean update(User user);
	
	
	public boolean validate(String id, String password);
	
	// get all users   - list
	
	public List<User>     list();
	
	
	//get user details based on userID
	
	public User get(String id);

	public User getByEmailId(String name);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
