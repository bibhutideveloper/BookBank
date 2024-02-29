package com.project.bookbank.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.project.bookbank.model.Users;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("users")
    public Users getUsersModel() {
        return new Users();
    }
    
    @ModelAttribute("loggedInUser")
    public Users getUserSessionData(HttpSession session) {
    	Users loggedInUser = (Users) session.getAttribute("loggedInUser");
    	return loggedInUser;
    }
}
