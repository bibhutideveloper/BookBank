package com.project.bookbank.service;

import com.project.bookbank.model.Admin;

public interface AdminService {
	Admin findByAdminUsername(String adminUsername);
}
