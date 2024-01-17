package com.project.bookbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.bookbank.model.Users;
import com.project.bookbank.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String viewHomepage(Model model) {
		return "index";
	}
	
	// login
	@PostMapping("/")
	public String processLogin(@Valid Users users, BindingResult result ,String userEmail, String userPassword, Model model, HttpSession session) {
		Users user = userService.findByUserEmail(userEmail);
		try {
			if(result.hasErrors()) {
				model.addAttribute("errorMessage", "Login Failed !");
				return "index";
			}
			
			if(user != null && userPassword.equals(user.getUserPassword())){
				session.setAttribute("LoggedInUser",user);
				System.out.println(user.getUserName());
				
				model.addAttribute("successMessage", "Login Successful.");
				return "redirect:/?success";
			}else {
				model.addAttribute("errorMessage", "Login Failed !");
				return "redirect:/?error";
			}
		}catch(Exception e) {
			return "redirect:/?error";
		}
	}
	
	// sign up
	@GetMapping("/signUp")
	public String showSignUpPage(Model model) {
		try {
			model.addAttribute("users", new Users());;		
			return "signUp";
		}catch(Exception e) {
			return "index";
		}
	}
	
	
	@PostMapping("/signUp")
	public String processLogin(@ModelAttribute("users") Users users) {
		try {
			userService.saveUser(users);
			return "redirect:/?success";
		}catch(Exception e) {
			return "redirect:/signUp?error";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/?logout";
	}
	
	@GetMapping("/admin/users")
	public String getAllUsers(Model model) {
		try {
			model.addAttribute("listUsers", userService.findAllUsers());
			return "admin/users";
		}catch(Exception e) {
			return "redirect:/admin";
		}
	}
	
	@GetMapping("/admin/update_users/{userId}")
	public String viewUpdateUserForm(@PathVariable("userId") Integer userId, Model model) {
		Users users = userService.findByUserId(userId);
		model.addAttribute("users", users);
		return "admin/update_users";
	}
	
	@GetMapping("/admin/add_users")
	public String showAddUsersForm(Model model) {
		try {
			model.addAttribute("users", new Users());;		
			return "admin/add_users";
		}catch(Exception e) {
			return "redirect:/admin/users";
		}
	}
	
	@PostMapping("/admin/add_users")
	public String processUpdateUsers(@ModelAttribute("users") Users users) {
		try {
			userService.saveUser(users);
			return "admin/users/?success";
		}catch(Exception e) {
			return "redirect:/admin/update_users/?error";
		}
	}
	
	@GetMapping("/admin/delete_user")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		try {
			userService.deleteByUserId(userId);
			return "admin/users";
		}catch(Exception e) {
			return "redirect:/admin/users";
		}
	}
}
