package com.example.librarymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.librarymgmt.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

}
