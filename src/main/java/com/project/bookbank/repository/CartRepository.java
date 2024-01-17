package com.project.bookbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookbank.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	void save(String ownType, Integer bookId, Integer userId);

}
