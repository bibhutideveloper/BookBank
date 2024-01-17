package com.project.bookbank.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.project.bookbank.model.Users;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("users")
    public Users getUsersModel() {
        return new Users();
    }
}
