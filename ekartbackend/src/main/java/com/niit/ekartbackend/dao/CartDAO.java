package com.niit.ekartbackend.dao;

import java.util.List;

import com.niit.ekartbackend.domain.Cart;

public interface CartDAO {

	public List<Cart> list();

	public Cart getByCartId(int cartid);

	public Cart getByProductId(int productid);		

	public  List<Cart> getByEmailId(String email);

	public Cart getByProductName(String productname);	

	public void delete(int cartId);

	public Long getTotalAmount(int id);

	public boolean itemAlreadyExist(String email, String productId, boolean b);

	public Cart getByUserandProduct(String email, String productId);

	public void saveOrUpdate(Cart cart);
	public void save(Cart cart);
	public void update(Cart cart);
	}
