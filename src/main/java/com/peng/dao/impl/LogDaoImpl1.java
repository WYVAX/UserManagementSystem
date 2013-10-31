package com.peng.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.peng.dao.*;
import com.peng.model.Log;

@Component
public class LogDaoImpl1 implements LogDao {

	private SessionFactory sf;
	
	public SessionFactory getSf() {
		return sf;
	}

	@Resource
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void create(Log o) {
		Session s = sf.getCurrentSession();
		//throw new RuntimeException();
		s.save(o);
		
	}

	@Override
	public void delete(Log o) {
		Session s = sf.getCurrentSession();
		s.delete(o);
	}

	

}
