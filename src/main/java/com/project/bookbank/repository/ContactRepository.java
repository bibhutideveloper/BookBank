package com.project.bookbank.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookbank.model.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer>{

}

