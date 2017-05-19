package com.niit.ekartbackend.dao;

import java.util.List;

import com.niit.ekartbackend.domain.Billing;

public interface BillingDAO {

	public  boolean save(Billing billing);
	public boolean update(Billing billing);
    
	public List<Billing>     list();
}
