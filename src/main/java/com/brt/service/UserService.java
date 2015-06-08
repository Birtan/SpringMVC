package com.brt.service;

import java.util.List;

import com.brt.domain.User;

public interface UserService {

	void save(User user);

	void delete(String id);

	void update(User user);

	List<User> listUserRepository();

	User find(User user);

}
