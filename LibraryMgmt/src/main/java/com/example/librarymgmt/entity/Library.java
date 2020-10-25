package com.example.librarymgmt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NaturalId;

@Entity
public class Library implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sectionId;
	@NaturalId
	private String sectionName;
	private int bookCount;
	
	@OneToMany(mappedBy = "library",cascade = CascadeType.ALL)
	private List<Book> books;
	
	public Library() {
		
	}

	public Library(String sectionName, int bookCount,List<Book> books) {
		super();
		this.sectionName = sectionName;
		this.bookCount = bookCount;
		this.books = books;
	}
	
	public int getSectionId() {
		return sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}
	

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
		
		  for(Book b : books) {
			  b.setLibrary(this); 
		}
		 
	}
	

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	@Override
	public String toString() {
		return "Library [sectionName=" + sectionName + ", bookCount=" + bookCount + "]";
	}
	
	
	
}
