package com.project.bookbank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cart_id")
	private Integer cartId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users users;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Books books;
	
	@Column(name="book_qty")
	private Integer bookQuantity;
	
	@Column(name="own_type")
	private String ownType;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public Integer getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(Integer bookQuantity) {
		this.bookQuantity = bookQuantity;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", users=" + users + ", books=" + books + ", bookQuantity=" + bookQuantity
				+ "]";
	}
	
}
