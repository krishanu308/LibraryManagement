package com.example.librarymgmt.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import com.example.librarymgmt.entity.Book;
import com.example.librarymgmt.entity.Library;
import com.example.librarymgmt.repository.LibraryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LibraryRepositoryTest {

	Book b1 = null;
	Library mockLibDtl = null;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Before
	public void setup() {
		b1 = new Book("Robert Lewis","Living species on earth","2009");
		mockLibDtl = new Library("Geography", 200,Arrays.asList(b1));
	}
	
	  @Test
	  public void LibraryRecords_IfNotEmpty() {
	   Iterable<Library> tutorials = libraryRepository.findAll();
	   assertThat(tutorials).isNotEmpty();
	  }
	  
	  @Test
	  public void noLibraryRecords_IfEmpty() {
	   Iterable<Library> tutorials = libraryRepository.findAll();
	   assertThat(tutorials).isEmpty();
	  }
	  
	  @Test
	  public void save_LibraryData() {
	   
		Library libbraryData = libraryRepository.save(mockLibDtl);

	    assertThat(libbraryData).hasFieldOrPropertyWithValue("sectionName", "Geography");
	    assertThat(libbraryData).hasFieldOrPropertyWithValue("bookCount", 200);
	  }
	  
	  @Test
	  public void should_find_tutorial_by_id() {
	    entityManager.persist(mockLibDtl);

	    Library libraryData= libraryRepository.findById(mockLibDtl.getSectionId()).get();

	    assertThat(libraryData).isEqualTo(mockLibDtl);
	  }
}
