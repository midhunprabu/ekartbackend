package com.niit.ekartbackend.dao;

import java.util.List;

import com.niit.ekartbackend.domain.Category;

public interface CategoryDAO {

	public  boolean saveOrUpdate(Category category);
	
	public List<Category>     list();
	
	public void delete(String id);
	public Category get(String id);
	
	
}
