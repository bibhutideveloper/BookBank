package com.project.bookbank.service;

import java.util.List;

import com.project.bookbank.model.Users;

public interface UserService {
	void saveUser(Users users);
	Users findByUserEmail(String userEmail);
	List<Users> findAllUsers();
	Users findByUserId(Integer userId);
	void deleteByUserId(Integer userId);
}
