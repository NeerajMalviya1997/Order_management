package com.masai.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.CurrentUserSession;
import com.masai.model.Products;
import com.masai.model.User;
import com.masai.Repo.ProductDao;
import com.masai.Repo.UserDao;
import com.masai.Repo.UserSessionDAO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private UserSessionDAO userSessionDAO;
	@Autowired
	private ProductDao productDao;
	
	@Override
	public User createUser(User user) {
		
		
		Optional<User> opt= userDao.findByMobileNo(user.getMobileNo());
		
		if(opt.isPresent()) {

			throw new RuntimeException("User already exist");
		}
		
		userDao.save(user);
		return user;
		
	}

	@Override
	public User updateUser(User user, String key) {

		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
		
			if(!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
			return userDao.save(user);

	}

	@Override
	public String orders(Integer productid, Integer items, String key) {
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			Optional<Products> prod  =productDao.findById(productid);
			
		return prod.get();
	}

}
