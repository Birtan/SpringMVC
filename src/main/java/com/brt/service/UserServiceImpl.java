package com.brt.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.brt.dao.UserRepository;
import com.brt.domain.User;

@Repository("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Inject
	private UserRepository userRepositoryImpl;

	public UserServiceImpl() {

	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepositoryImpl.save(user);

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		userRepositoryImpl.delete(id);

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userRepositoryImpl.update(user);

	}

	public void setUserRepositoryImpl(UserRepository userRepository) {
		this.userRepositoryImpl = userRepository;
	}

	@Override
	public List<User> listUserRepository() {
		List<User> userRepList = (List<User>) userRepositoryImpl
				.listUserRepository();
		return userRepList;

	}

	@Override
	public User find(User user) {
		User userFind = userRepositoryImpl.find(user);
		return userFind;
	}
}
