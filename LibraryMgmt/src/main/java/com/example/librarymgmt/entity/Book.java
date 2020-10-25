package com.example.librarymgmt.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

// Table Book

@Entity
public class Book{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String author;
	private String publishedYear;
	
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "SECTION_NAME",referencedColumnName = "sectionName")
		@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
		private Library library;
	
	public Book() {
		
	}
	
	public Book(String name, String author, String publishedYear) {
		super();
		this.name = name;
		this.author = author;
		this.publishedYear = publishedYear;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}

	public String getPublishedYear() {
		return publishedYear;
	}
	

	
	 public Library getLibrary() { 
		 return library; 
	 }
	 
	  public void setLibrary(Library library) { 
		  this.library = library; 
	  }
	 

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publishedYear=" + publishedYear + "]";
	}
	
	
	
}
