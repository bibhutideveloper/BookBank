package com.project.bookbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.bookbank.model.Genres;
import com.project.bookbank.service.GenresService;

@Controller
public class GenresController {
	@Autowired
	private GenresService genresService;
	
	// genre page
	@GetMapping("/genre")
	public String showGenrePage() {
		return "genre";
	}
	
	@GetMapping("/shop/genre/{bgId}")
	public String showGenreDetails(@PathVariable Integer bgId, Model model) {
	    try {
	        Genres genre = genresService.getGenresById(bgId);
	        model.addAttribute("genre", genre);
	        return "genreDetails";
	    } catch(Exception e) {
	        return "redirect:/shop";
	    }
	}
	
	
	// all genres data in admin page
	@GetMapping("/admin/genres")
	public String getAllGenres(Model model) {		
		try {
			model.addAttribute("listGenres", genresService.getAllGenres());
			return "admin/genres";
		}catch(Exception e) {
			return "redirect:/admin/adminDashboard";
		}
	}
	
	// open add genres page
	@GetMapping("/admin/add_genres")
	public String viewAddGenresForm(Model model) {
		try {
			model.addAttribute("genres", new Genres());
			return "admin/add_genres";
		}catch(Exception e) {
			return "admin/genres";
		}
	}
	
	// save genres data
	@PostMapping("/admin/add_genres")
	public String saveGenres(@ModelAttribute("genres") Genres genres) {
		try {
			genresService.saveGenres(genres);
			return "redirect:/admin/add_genres?success";
		}catch(Exception e) {
			return "redirect:/admin/add_genres?error";
		}
	}
	
	// open update_genre page
	@GetMapping("/admin/update_genres/{bgId}")
	public String viewUpdateGenresForm(@PathVariable("bgId") Integer bgId, Model model) {
		Genres genres = genresService.getGenresById(bgId);
		model.addAttribute("genres", genres);
		return "admin/update_genres";
	}
	
	// delete genre
	@GetMapping("admin/delete_genres/{bgId}")
	public String deleteGenres(@PathVariable("bgId") Integer bgId) {
		genresService.deleteGenresById(bgId);
		return "redirect:/admin/genres";
	}
}
