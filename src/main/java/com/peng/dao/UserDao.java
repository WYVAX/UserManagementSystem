package com.peng.dao;

import com.peng.model.*;

public interface UserDao {
	public void create(User u);
	public void delete(User u);
	public void update(User u);
	public User get(int id);
	public User getFirst();
}
