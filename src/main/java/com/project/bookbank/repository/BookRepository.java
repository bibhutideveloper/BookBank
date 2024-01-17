package com.project.bookbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookbank.model.Books;

public interface BookRepository extends JpaRepository<Books, Integer> {

}
