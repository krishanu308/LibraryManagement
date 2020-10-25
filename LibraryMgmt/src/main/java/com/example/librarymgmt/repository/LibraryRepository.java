package com.example.librarymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.librarymgmt.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer>{

}
