package com.project.bookbank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookbank.model.Books;
import com.project.bookbank.model.Genres;
import com.project.bookbank.repository.GenresRepository;
import com.project.bookbank.service.GenresService;

@Service
public class GenresServiceImpl implements GenresService {

	@Autowired
	private GenresRepository genresRepository;
	
	@Override
	public List<Genres> getAllGenres() {
		return genresRepository.findAll();
	}

	@Override
	public void saveGenres(Genres genres) {
		this.genresRepository.save(genres);
	}

	@Override
	public Genres getGenresById(Integer bgId) {
		Optional<Genres> optional = genresRepository.findById(bgId);
		Genres genres = null;
		
		if(optional.isPresent()) {
			genres = optional.get();
		}else {
			throw new RuntimeException(" genres not found for id :: "+bgId);
		}
		
		return genres;
	}

	@Override
	public void deleteGenresById(Integer bgId) {
		genresRepository.deleteById(bgId);
	}
	
	
	@Override
	public List<Books> getBooksByGenreId(Integer bgId) {
	    Optional<Genres> optionalGenres = genresRepository.findById(bgId);

	    if (optionalGenres.isPresent()) {
	        Genres genre = optionalGenres.get();
	        return genre.getBook(); // This assumes that your Genres entity has a List<Book> field named "books"
	    } else {
	        throw new RuntimeException("Genre not found for id: " + bgId);
	    }
	}

}
