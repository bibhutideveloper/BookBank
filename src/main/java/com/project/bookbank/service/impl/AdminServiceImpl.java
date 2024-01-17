package com.project.bookbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookbank.model.Admin;
import com.project.bookbank.repository.AdminRepository;
import com.project.bookbank.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin findByAdminUsername(String adminUsername) {
		return adminRepository.getByAdminUsername(adminUsername);
	}
	
}
