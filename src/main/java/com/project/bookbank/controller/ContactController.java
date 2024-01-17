package com.project.bookbank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.bookbank.model.Contact;
import com.project.bookbank.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact")
	public String viewContactPage(Model model)
	{
		model.addAttribute("contact", new Contact());
		return "contactUs";
	}
	
	@PostMapping("/contact")
	public String saveContact(@ModelAttribute("contact") Contact contact)
	{
		try {
			contactService.saveContact(contact);
			System.out.println("Message sent successfully");
			return "redirect:/contact?success";
		}
		catch(Exception e)
		{
			System.out.println("Failed to sent Message");
			return "redirect:/contact?error";
		}
		
	}
	
	
	@GetMapping("/about")
	public String viewAboutPage(Model model)
	{
		model.addAttribute("about", new Contact());
		return "aboutUs";
	}
}

