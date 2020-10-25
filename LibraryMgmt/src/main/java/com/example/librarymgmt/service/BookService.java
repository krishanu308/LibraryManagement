package com.example.librarymgmt.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.librarymgmt.entity.Book;
import com.example.librarymgmt.repository.BookRepository;

@Service

public interface BookService extends BookRepository{

	default void removeSpecificBook(int bookId) {
	deleteById(bookId);
	}
	
	default public Book updateSpecificBookInLibrary(int bookId,Book book) {
		Optional<Book> bookDtls = findById(bookId); 
		  Book bookObjFromDB  = bookDtls.get(); 
		  if(bookObjFromDB.getId() == bookId) {
			bookObjFromDB.setAuthor(book.getAuthor());
		  	bookObjFromDB.setName(book.getName());
		  	bookObjFromDB.setPublishedYear(book.getPublishedYear());
		  	save(bookObjFromDB);
		  }
		  return bookObjFromDB;
	}
	
}
