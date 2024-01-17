package com.project.bookbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.bookbank.service.BookService;
import com.project.bookbank.service.GenresService;

@Controller
public class ShopController {
	
	@Autowired
	private GenresService genresService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/shop")
	public String viewHomepage(Model model) {
		model.addAttribute("listBook", bookService.getaAllBooks());
        model.addAttribute("listGenres", genresService.getAllGenres());
		return "shop";
	}
}
