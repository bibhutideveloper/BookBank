package com.project.bookbank.service;

import com.project.bookbank.model.Cart;

public interface CartService {
	void addToCart(String ownType, Integer bookId, Integer userId);
	Cart findByCartId(Integer cartId);
	void deleteCartById(Integer cartId);
	Double calculateTotalPrice(Cart cart);
	Cart findCartByUserId(Integer cartId);
	void incrementQuantity(Cart cart);
	void decrementQuantity(Cart cart);
}
