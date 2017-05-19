package com.niit.ekartbackend.dao;

import java.util.List;

import com.niit.ekartbackend.domain.Product;

public interface ProductDAO {

	public  boolean save(Product product);
	public boolean update(Product product);
    
	public List<Product>     list();
	
	public void delete(String id);
}
