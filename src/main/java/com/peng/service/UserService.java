package com.peng.service;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.peng.dao.*;
import com.peng.model.Log;
import com.peng.model.User;

@Component
public class UserService {
	private UserDao userDao;
	private LogDao logDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource(name = "userDaoMysql")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public LogDao getLogDao() {
		return logDao;
	}

	@Resource(name = "logDaoImpl1")
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(User u)  {
		userDao.create(u);
		Log log = new Log();
		log.setInfo(u.toString() + " is added.");
		logDao.create(log);
	}
	
	@Transactional
	public User get(String username){
		return userDao.get(username);
	}
	
	@Transactional
	public User getFirst(){
		return userDao.getFirst();
	}
	
	@Transactional
	public boolean delete(String username){
		User user = get(username);
		if(exists(user)){
			userDao.delete(user);
			return true;
		}
		else return false;
	}
	
	@Transactional
	public boolean delete(User u){
		if(exists(u)){
			userDao.delete(u);
			return true;
		}
		else return false;
	}
	
	@Transactional
	public boolean exists(User u){
		return (u.getUsername()!= null); 
	}
	
	@Transactional
	public Set getAll(){
		return userDao.getAll();
	}
}
