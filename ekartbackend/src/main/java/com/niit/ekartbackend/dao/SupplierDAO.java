package com.niit.ekartbackend.dao;

import java.util.List;

import com.niit.ekartbackend.domain.Supplier;


public interface SupplierDAO {

	
	
	public List<Supplier>     list();
	
	public void delete(String id);
	public boolean saveOrUpdate(Supplier supplier);

	public Supplier get(String id);
}
