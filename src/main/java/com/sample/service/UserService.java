package com.sample.service;

import java.util.List;

import com.sample.model.User;

public interface UserService {
  public void addUser(User u);
  public void updateUser(User u);
  public List<User> listUsers();
  public User getUserById(int id);
  public void removeUserById(int id);
}


