package com.project.bookbank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookbank.model.Users;
import com.project.bookbank.repository.UserRepository;
import com.project.bookbank.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(Users users) {
		this.userRepository.save(users);
	}

	@Override
	public Users findByUserEmail(String userEmail) {
		Users users = userRepository.getByUserEmail(userEmail);
		return users;
	}

	@Override
	public List<Users> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Users findByUserId(Integer userId) {
		Optional<Users> optional = userRepository.findById(userId);
		Users users = null;
		if(optional.isPresent()) {
			users = optional.get();
		}else {
			throw new RuntimeException("User not found for id::"+userId);
		}
		
		return users;
	}

	@Override
	public void deleteByUserId(Integer userId) {
		userRepository.deleteById(userId);
	}
	
}
