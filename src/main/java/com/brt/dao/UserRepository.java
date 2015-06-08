package com.brt.dao;

import java.util.List;

import com.brt.domain.User;

public interface UserRepository {

	void save(User user);

	void delete(String id);

	void update(User user);
	
	List<User> listUserRepository();
	
	User find(User user);

}
