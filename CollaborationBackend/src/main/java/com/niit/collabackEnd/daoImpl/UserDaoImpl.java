package com.niit.collabackEnd.daoImpl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.collabackEnd.dao.UserDao;
import com.niit.collabackEnd.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory session;
	

	@Override
	public void saveUser(User user) {
		session.getCurrentSession().persist(user);
		
	}

	
}
