package com.project.bookbank.service.impl;

import java.util.List;
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
	
//	@Override
//	public void addToCart(String ownType, Integer bookId, Integer userId) {
//		cartRepository.save(ownType, bookId, userId);
//	}
	
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
	
//	@Override
//	public List<Cart> findByUserId(Integer userId) {
//		List<Cart> cartList = cartRepository.findByUserId(userId);
//		if(cartList.isEmpty()) {
//			throw new RuntimeException("Cart data not found for cart id :: "+userId);
//		}
//		return cartList;
//	}

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
	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

}
