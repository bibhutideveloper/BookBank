package com.project.bookbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookbank.model.Genres;

public interface GenresRepository extends JpaRepository<Genres, Integer> {

}
