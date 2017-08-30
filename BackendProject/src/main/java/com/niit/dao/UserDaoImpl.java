package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;
@Transactional
@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
@Transactional
	public User registerUser(User user) {
		
      Session s =sessionFactory.openSession();
      s.save(user);
      s.flush();
      s.close();
      return user;
	}
	public User login(User user) {
		String hql="from User where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		User validUser=(User)query.uniqueResult();
		return validUser;
		
	}

	public void updateUser(User user) {
		Session session=sessionFactory.openSession();
		//update user_batch15 set username=?,password=?,email=?,enabled=?,online=? where id=?
		session.update(user);
		session.flush();
		session.close();
	}
	public User getUser(int id) {
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class, id);
		session.close();
		return user;
		
	}
	public List<String> getOnlineUsers() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("select username from User where online=1");
		List<String> onlineUsers=query.list();
		session.close();
		return onlineUsers;
	}
	
}
