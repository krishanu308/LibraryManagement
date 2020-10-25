package com.example.librarymgmt.controller;

import java.util.Arrays;
import java.util.List;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
 
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
 

import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.librarymgmt.entity.Book;
import com.example.librarymgmt.entity.Library;
import com.example.librarymgmt.service.BookService;

import com.example.librarymgmt.service.LibraryService;

@WebMvcTest
public class LibraryMgmtControllerTests {

	private static ObjectMapper mapper = new ObjectMapper();
	
	@Autowired 
	private MockMvc mockMvc;
	 
	
	@MockBean
	private LibraryService libraryService;

	@MockBean
	private BookService bookService;
	
	@Test
	public void createLibraryEntry() throws Exception {
		Library libDtls = new Library();
		libDtls.setSectionName("Geography");
		libDtls.setBookCount(200);
		Book b1 = new Book();
		b1.setName("Cosmos Theory");
		b1.setAuthor("Adam");
		b1.setPublishedYear("2002");
		libDtls.setBooks(Arrays.asList(b1));
		
		Mockito.when(libraryService.createLibraryRecord(ArgumentMatchers.any())).thenReturn(libDtls);
		String json = mapper.writeValueAsString(libDtls);
		
		mockMvc.perform(post("/library").
				contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.bookCount", Matchers.equalTo(200)))
		        .andExpect(jsonPath("$.sectionName", Matchers.equalTo("Geography")));
	}
	
	@Test
	public void fetchAllLibraryData() throws Exception {
		Library libDtls = new Library();
		libDtls.setSectionId(1005);
		libDtls.setSectionName("Human Psychology");
		Book b1 = new Book();
		b1.setName("Cosmos Theory");
		b1.setAuthor("Adam");
		b1.setPublishedYear("2002");
		libDtls.setBooks(Arrays.asList(b1));
		List<Book> bookList = libDtls.getBooks();
		Mockito.when(libraryService.fetchAllBooksFromLibrary()).thenReturn(bookList);
				
		mockMvc.perform(get("/library/books")).
		 andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(1)));
	}
}
