package com.project.bookbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.bookbank.model.Admin;
import com.project.bookbank.service.AdminService;

@Controller
public class AdminController {
	
	private Admin admin;
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin")
	public String viewAdminPage(Model model) {
		try {
			model.addAttribute("admin", new Admin());
			return "/admin/index";
		}catch(Exception e){
			return "/";
		}
	}
	
	@PostMapping("/admin")
	public String processLogin(String adminUsername, String adminPassword ,Model model) {
		admin = adminService.findByAdminUsername(adminUsername);
		
		try {
			if(adminUsername != null && adminPassword.equals(admin.getAdminPassword())){
				System.out.println("Admin Login success");
				model.addAttribute("successMessage", "Admin Login Successful.");
				return "redirect:/admin/adminDashboard?success";
			}
			else {
				model.addAttribute("errorMessage", "Admin Login Failed !");
				System.out.println("Admin Login Failed");
				return "redirect:/admin?error";
			}
		}catch(Exception e) {
			
			return "redirect:/admin";
		}
		
	}
	
	@GetMapping("admin/adminDashboard")
	public String showAdminDashboard(Model model) {
		try {
			model.addAttribute("admin", admin);
			return "admin/adminDashboard";
		}catch(Exception e) {
			return "/admin";
		}
	}
	
}
