package com.raster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.raster.exceptions.BookNotFoundException;
import com.raster.exceptions.InvalidRequestException;

import jakarta.transaction.Transactional;
@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Page<Book> getBooks(Pageable pageable, String category){
		Page<Book> books;
		
		if(category.length() == 0) {
			books = bookRepository.findAll(pageable);
		}else if(isAbsent(category)) {
			throw new InvalidRequestException("Request does not have a valid category");
		}else {
			books = bookRepository.findByCategory(category, pageable);
		}
		
		if(books.getSize() == 0) {
			throw new BookNotFoundException("No books found");
		}
		
		return books;
	}
	
	private boolean isAbsent(String category) {
		String[] categories = {"Madical", "Art-Photography", "Science-Geography", "Biography", "Business-Finance-Law", "Childrens-Books", "Computing"};
		for(String cat: categories) {
			if(cat.equals(category)) {
				return true;
			}
		}
		return false;
	}


	@Transactional
	public void addBooks(List<Book> books) {
		if(books.size() == 0) {
			throw new NullPointerException("There are no books in RequestBody");
		}
		
		int batchSize = 10;
		for(int i = 0; i < books.size(); i += batchSize) {
			List<Book> batch = books.subList(i, i + batchSize > books.size() ? books.size(): books.size() + batchSize);
			bookRepository.saveAll(batch);
		}
	}
}
