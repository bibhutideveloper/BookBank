package com.project.bookbank.service;

import java.util.List;

import com.project.bookbank.model.Books;
import com.project.bookbank.model.Genres;

public interface GenresService {
	List<Genres> getAllGenres();
	void saveGenres(Genres genres);
	Genres getGenresById(Integer bgId);
	void deleteGenresById(Integer bgId);
	List<Books> getBooksByGenreId(Integer bgId);
}
