package com.project.bookbank.service;

import java.util.List;

import com.project.bookbank.model.Cart;

public interface CartService {
//	void addToCart(String ownType, Integer bookId, Integer userId);
	Cart findByCartId(Integer cartId);
//	List<Cart> findByUserId(Integer userId);
	void deleteCartById(Integer cartId);
	List<Cart> findAll();
	Double calculateTotalPrice(Cart cart);
	void incrementQuantity(Cart cart);
	void decrementQuantity(Cart cart);
}
