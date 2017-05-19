package com.niit.ekartbackend.dao;

import java.util.List;

import com.niit.ekartbackend.domain.Shipping;


public interface ShippingDAO {

	
	public  boolean save(Shipping shipping);
	public boolean update(Shipping shipping);
    
	public List<Shipping>     list();
	
}
