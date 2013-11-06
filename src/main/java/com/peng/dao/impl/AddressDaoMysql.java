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

import com.peng.dao.AddressDao;
import com.peng.dao.UserDao;
import com.peng.model.Address;
import com.peng.model.User;

@Component("addressDaoMysql")
public class AddressDaoMysql implements AddressDao{

	private SessionFactory sf;
	
	public SessionFactory getSf() {
		return sf;
	}

	@Resource
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void create(Address a) {
		Session s = sf.getCurrentSession();
		s.save(a);
		
	}

	@Override
	public void delete(Address a) {
		Session s = sf.getCurrentSession();
		s.delete(a);
	}

	@Override
	public void update(Address a) throws SQLException{
		Session s = sf.getCurrentSession();
		s.update(a);
	}
	
	@Override
	public void updateCRUD(Address a) {
		Session s = sf.getCurrentSession();
		Address addr = get(a.getId());
		addr.setRoomNumber(a.getRoomNumber());
		addr.setStreetAddr(a.getStreetAddr());
		addr.setStreetAddr2(a.getStreetAddr2());
		addr.setState(a.getState());
		addr.setCountry(a.getCountry());
		s.update(addr);
	}
	@Override
	public Address get(int id) {
		Session s = sf.getCurrentSession();
		Address a = (Address) s.get(Address.class, id);
		return a;
	}
	
	@Override
	public Address getFirst(){
		Session s = sf.getCurrentSession();
		Query query = s.createQuery("from  Address as address order by address.id");
		query.setMaxResults(1);
		Address a = (Address)query.uniqueResult();
		return a;
	}
	
	@Override
	public Set<Address> getAll(){
		Session s = sf.getCurrentSession();
		Query query = s.createQuery("from  Address as addr order by addr.id");
		
		List listaddrs=  query.list();
		Set<Address> addresses= new HashSet<Address>(listaddrs);
		return addresses;
		
	}


}
