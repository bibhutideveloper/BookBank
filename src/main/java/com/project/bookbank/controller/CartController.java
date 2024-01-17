package com.project.bookbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.bookbank.model.Cart;
import com.project.bookbank.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/cart")
	public String viewCartPage(Model model) {
		try {
			List<Cart> listCart = cartService.findCartByUserId(userId);
			Double grandTotal = calculateGrandTotal(listCart);

            model.addAttribute("listCart", listCart);
            model.addAttribute("grandTotal", grandTotal);

			return "cart";
		}catch(Exception e) {
			return "redirect:/";
		}
	}

	private Double calculateGrandTotal(List<Cart> listCart) {
		Double grandTotal = 0.0;
		for(Cart cart : listCart) {
			double totalPrice = cart.getBooks().getBookPrice() * cart.getBookQuantity();
			grandTotal += totalPrice;
		}
		return grandTotal;
	}
	
	@PostMapping("/updateQuantity")
    public String updateQuantity(@RequestParam("cartId") Integer cartId, @RequestParam("operation") String operation) {
        try {
            Cart cart = cartService.findByCartId(cartId);
            if (cart != null) {
                if ("increment".equals(operation)) {
                    cartService.incrementQuantity(cart);
                } else if ("decrement".equals(operation)) {
                    cartService.decrementQuantity(cart);
                }
            }
            return "redirect:/cart";
        } catch (Exception e) {
            return "redirect:/cart?error";
        }
    }

	
	@PostMapping("/deleteCartItem")
    public String deleteCartItem(@RequestParam("cartId") Integer cartId) {
        try {
            cartService.deleteCartById(cartId);
            return "redirect:/cart";
        } catch (Exception e) {
            return "redirect:/cart?error";
        }
    }
	
	// Add to cart, rent, wishlist
	@PostMapping("/addToAction")
	public String addToCart(@RequestParam("ownType") String ownType, @RequestParam("bookId") Integer bookId, @RequestParam("userId") Integer userId) {
		try {
			
			cartService.addToCart(ownType, bookId, userId);
			return "shop";
		}catch(Exception e) {
			return "shop";
		}
	}
	
	// checkout
//	@GetMapping("/checkout")
//    public String checkoutPage(Model model) {
//		try {
//			List<Cart> listCart = cartService.getAllCart();
//			Double grandTotal = calculateGrandTotal(listCart);
//
//            model.addAttribute("listCart", listCart);
//            model.addAttribute("grandTotal", grandTotal);
//
//			return "checkout";
//		}catch(Exception e) {
//			return "redirect:/";
//		}
//    }

}
