package com.project.bookbank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookbank.model.Books;
import com.project.bookbank.repository.BookRepository;
import com.project.bookbank.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Books> getaAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public void saveBooks(Books books) {
		this.bookRepository.save(books);
	}

	@Override
	public Books getBooksById(Integer bookId) {
		Optional<Books> optional = bookRepository.findById(bookId);
		Books books = null;
		
		if(optional.isPresent()) {
			books = optional.get();
		}else {
			throw new RuntimeException("Book not found for id :: "+bookId);
		}
		
		return books; 
	}

	@Override
	public void deleteBooksById(Integer bookId) {
		bookRepository.deleteById(bookId);
	}

}
