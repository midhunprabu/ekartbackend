package com.niit.ekartbackend.dao;

import java.util.List;

import com.niit.ekartbackend.domain.Supplier;


public interface SupplierDAO {

	public  boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	
	public List<Supplier>     list();
	
	public void delete(String id);
}
