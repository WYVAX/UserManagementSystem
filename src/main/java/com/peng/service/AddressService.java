package com.peng.service;

import java.sql.SQLException;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.peng.dao.*;
import com.peng.model.Address;
import com.peng.model.Log;
import com.peng.model.User;

@Component("addressService")
public class AddressService {
	private AddressDao addressDao;
	private LogDao logDao;

	public AddressDao getAddressDao() {
		return addressDao;
	}

	@Resource(name="addressDaoMysql")
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public LogDao getLogDao() {
		return logDao;
	}

	@Resource(name = "logDaoImpl1")
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void add(Address a)  {
		addressDao.create(a);
		Log log = new Log();
		log.setInfo(a.toString() + " is added.");
		logDao.create(log);
	}
	
	@Transactional
	public Address get(int id){
		return addressDao.get(id);
	}
	
	@Transactional
	public Address getFirst(){
		return addressDao.getFirst();
	}
	
	@Transactional
	public boolean delete(int id){
		Address addr = get(id);
		if(exists(addr)){
			addressDao.delete(addr);
			return true;
		}
		else return false;
	}
	
	@Transactional
	public boolean delete(Address a){
		if(exists(a)){
			addressDao.delete(a);
			return true;
		}
		else return false;
	}
	
	@Transactional
	public boolean update(Address u) throws SQLException{
		addressDao.update(u);
		return true;
	}
	
	@Transactional
	public boolean updateCRUD(Address a){
		addressDao.updateCRUD(a);
		return true;
	}
	
	@Transactional
	public boolean exists(Address a){
		return (a.getId() != 0 && a.getUser() != null);
	}
	
	@Transactional
	public Set getAll(){
		return addressDao.getAll();
	}
}
