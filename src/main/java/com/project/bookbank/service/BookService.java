package com.project.bookbank.service;

import java.util.List;

import com.project.bookbank.model.Books;

public interface BookService {
	List<Books> getaAllBooks();
	void saveBooks(Books books);
	Books getBooksById(Integer bookId);
	void deleteBooksById(Integer bookId);
}
