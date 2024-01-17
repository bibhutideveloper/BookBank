package com.project.bookbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookbank.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin getByAdminUsername(String adminUsername);
}
