package com.project.bookbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookbank.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	Users getByUserEmail(String userEmail);
}
