package com.project.bookbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.bookbank.model.Books;
import com.project.bookbank.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	// all book data
	@GetMapping("/admin/books")
	public String getAllBooks(Model model) {		
		try {
			model.addAttribute("listBooks", bookService.getaAllBooks());
			return "admin/books";
		}catch(Exception e) {
			return "redirect:/admin/adminDashboard";
		}
	}
	
	// open add book page
	@GetMapping("/admin/add_books")
	public String viewAddBookForm(Model model) {
		try {
			model.addAttribute("books", new Books());
			return "admin/add_books";
		}catch(Exception e) {
			return "admin/books";
		}
	}
	
	// save book data
	@PostMapping("/admin/add_books")
	public String saveBook(@ModelAttribute("books") Books books) {
		try {
			bookService.saveBooks(books);
			return "redirect:/admin/add_books?success";
		}catch(Exception e) {
			return "redirect:/admin/add_books?error";
		}
	}
	
	// open update_book page
	@GetMapping("/admin/update_books/{bookId}")
	public String viewUpdateBookForm(@PathVariable("bookId") Integer bookId, Model model) {
		Books books = bookService.getBooksById(bookId);
		model.addAttribute("books", books);
		return "admin/update_books";
	}
	
	// delete book
	@GetMapping("admin/delete_books/{bookId}")
	public String deleteBooks(@PathVariable("bookId") Integer bookId) {
		bookService.deleteBooksById(bookId);
		return "redirect:/admin/books";
	}
	
}
