package com.project.bookbank.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookbank.model.Cart;
import com.project.bookbank.repository.CartRepository;
import com.project.bookbank.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public void addToCart(String ownType, Integer bookId, Integer userId) {
		cartRepository.save(ownType, bookId, userId);
	}

	@Override
    public void deleteCartById(Integer cartId) {
        cartRepository.deleteById(cartId);
    }

	@Override
	public Double calculateTotalPrice(Cart cart) {
		Double bookPrice = cart.getBooks().getBookPrice();
		Integer bookQuantity = cart.getBookQuantity();
		return bookPrice * bookQuantity;
	}

	@Override
	public void incrementQuantity(Cart cart) {
		cart.setBookQuantity(cart.getBookQuantity() + 1);
		cartRepository.save(cart);
	}

	@Override
	public void decrementQuantity(Cart cart) {
		if (cart.getBookQuantity() > 1) {
			cart.setBookQuantity(cart.getBookQuantity() - 1);
			cartRepository.save(cart);
		}
	}

	@Override
	public Cart findCartByUserId(Integer cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart findByCartId(Integer cartId) {
		Optional<Cart> optional = cartRepository.findById(cartId);
		Cart cart = null;
		if(optional.isPresent()) {
			cart = optional.get();
		}else {
			throw new RuntimeException("Book not found for id :: "+cartId);
		}
		
		return cart;
	}

}
