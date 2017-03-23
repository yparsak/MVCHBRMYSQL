package com.sample.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.UserDao;
import com.sample.model.User;

public class UserServiceImpl implements UserService {
	
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public void addUser(User u) {
		this.userDao.addUser(u);
	}


	@Transactional
	public void updateUser(User u) {
       this.userDao.updateUser(u);
	}


	@Transactional
	public List<User> listUsers() {
      return this.userDao.listUsers();
	}

	@Transactional
	public User getUserById(int id) {
		return this.userDao.getUserById(id);
	}

	@Transactional
	public void removeUserById(int id) {
		this.userDao.removeUserById(id);
	}
}
