package com.niit.ekartbackend.dao;

import java.util.List;

import com.niit.ekartbackend.domain.Mycart;

public interface MycartDAO {

	public  boolean save(Mycart mycart);
	public boolean update(Mycart mycart);
    
	public List<Mycart>     list();
	
}
