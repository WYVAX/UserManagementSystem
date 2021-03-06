package com.peng.dao.impl;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.peng.dao.UserDao;
import com.peng.model.User;

@Component("userDaoMysql")
public class UserDaoMysql implements UserDao{

	private SessionFactory sf;
	
	public SessionFactory getSf() {
		return sf;
	}

	@Resource
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void create(User u) {
		Session s = sf.getCurrentSession();
		s.save(u);
		
	}

	@Override
	public void delete(User u) {
		Session s = sf.getCurrentSession();
		s.delete(u);
	}

	@Override
	public void update(User u) throws SQLException{
		Session s = sf.getCurrentSession();
		s.update(u);
	}

	@Override
	public User get(String username) {
		Session s = sf.getCurrentSession();
		User u = (User) s.get(User.class, username);
		return u;
	}
	
	@Override
	public User getFirst(){
		Session s = sf.getCurrentSession();
		Query query = s.createQuery("from  User as user order by user.id");
		query.setMaxResults(1);
		User u = (User)query.uniqueResult();
		return u;
	}
	
	@Override
	public Set<User> getAll(){
		Session s = sf.getCurrentSession();
		Query query = s.createQuery("from  User as user order by user.id");
		
		List listusers =  query.list();
		Set<User> users = new HashSet<User>(listusers);
		return users;
		
	}
}
