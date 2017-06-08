package com.niit.ekartbackend.dao;

import java.util.List;

import com.niit.ekartbackend.domain.Product;

public interface ProductDAO {

	public boolean saveOrUpdate(Product product);

	public List<Product> list();

	public List<Product> list(String categoryName);
	
	public void delete(String productid);

	public Product get(String productid);

	public void save(Product product);

	public Product getByProductid(String productid);

}
