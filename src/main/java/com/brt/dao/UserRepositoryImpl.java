package com.brt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brt.domain.User;

@Repository("userRepositoryImpl")
@Transactional
public class UserRepositoryImpl implements UserRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public UserRepositoryImpl() {

	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		entityManager.persist(user);
		entityManager.flush();

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		entityManager.remove(id);

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		entityManager.merge(user);

	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUserRepository() {
		// TODO Auto-generated method stub

		Query query = entityManager.createNamedQuery("userFindAll", User.class);
		List<User> listUser = (List<User>) query.getResultList();
		return listUser;
	}

	@Override
	public User find(User user) {
		User findUser = entityManager.find(User.class, user);
		return findUser;
	}

}
