package com.peng.dao;

import java.sql.SQLException;
import java.util.Set;

import com.peng.model.*;

public interface AddressDao {
	public void create(Address a);
	public void delete(Address a);
	public void update(Address a) throws SQLException;
	public void updateCRUD(Address a);
	public Address get(int id);
	public Address getFirst();
	public Set<Address> getAll();
	
}
