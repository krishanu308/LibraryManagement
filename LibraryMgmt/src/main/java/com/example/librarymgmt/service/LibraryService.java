package com.example.librarymgmt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.librarymgmt.entity.Library;
import com.example.librarymgmt.repository.LibraryRepository;

@Service
public interface LibraryService extends LibraryRepository{

	default Library fetchLibraryDataBySectionId(int sectionid) throws Exception {
		System.out.println("fetchLibraryDataBySectionId::");
		Optional<Library> libraryDtls = findById(sectionid);

		if (!libraryDtls.isPresent())
				throw new Exception();
		
		return libraryDtls.get();
	}
	
	default List fetchAllBooksFromLibrary() {
		System.out.println("fetchAllBooksFromLibrary::");
		List books = new ArrayList();
		try {
		List<Library> libraryDtls = findAll();
		System.out.println("libraryDtls::"+libraryDtls);
		if (libraryDtls.isEmpty())
				throw new Exception();

		for (Library lib : libraryDtls) {
			if (lib.getBooks().size() > 0)
				books.add(lib.getBooks());
		}
		}catch(Exception ex) {
			System.out.println("Exception ex:"+ex.getMessage());
		}
		return books;
	}
	
	default Library createLibraryRecord(Library library) {
		Library libData = save(library);
		return libData;
	}
}
