package com.masai.Service;

import com.masai.model.Admin;
import com.masai.model.AdminDto;
import com.masai.model.Products;


public interface AdminLoginService {

	public String logIntoAccount(Admin adminDTO);
	
	public String logOutAccount(String key);

	public String logIntoAccount(AdminDto adminDTO);
	
	
	public Products saveProducts(Products product ,String key);
	
}
