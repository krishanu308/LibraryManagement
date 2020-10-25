package com.example.librarymgmt.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymgmt.entity.Book;
import com.example.librarymgmt.entity.Library;
import com.example.librarymgmt.service.BookService;
import com.example.librarymgmt.service.LibraryService;

@RestController
public class LibraryMgmtController {

	@Autowired
	private LibraryService libraryService;

	@Autowired
	private BookService bookService;
	

	@GetMapping("/library/{sectionId}")
	public Library getBooksBySection(@PathVariable int sectionId) throws Exception {
		return libraryService.fetchLibraryDataBySectionId(sectionId);
	}

	@GetMapping("/library/books")
	public List getAllBooks() throws Exception {
		return libraryService.fetchAllBooksFromLibrary();
	}

	@DeleteMapping("/library/books/{bookId}")
	public void deleteBook(@PathVariable int bookId) throws Exception {
		bookService.removeSpecificBook(bookId);
	}

	@PutMapping("/library/books/update/{bookId}")
	public Book updateBook(@PathVariable int bookId,@RequestBody Book book) throws Exception {
		return bookService.updateSpecificBookInLibrary(bookId,book);
	}

	
	@PostMapping("/library") 
	public Library createLibraryEntry(@RequestBody Library library) throws Exception{
		return libraryService.createLibraryRecord(library);
	}
	 

}
