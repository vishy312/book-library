package com.raster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/books")
	public ResponseEntity<List<Book>> addBooks(@Validated @RequestBody List<Book> books){
		if(books.size() == 0) {
			throw new NullPointerException("There are no books in RequestBody");
		}else {
			bookService.addBooks(books);
		}
		return ResponseEntity.ok(books);
		
	}
	
	@GetMapping("/")
	public String getHomePage(@Validated @RequestParam(name="sort", required=false, defaultValue="false") boolean sortByRating, @Validated @RequestParam(name="category", required=false, defaultValue="") String category, Model model) {
		Pageable pageable;
		if(sortByRating) {
			pageable = PageRequest.of(0, 10, Direction.ASC, "book_depository_stars");
		}else {
			pageable = PageRequest.of(0, 10, Direction.ASC, "name");
		}
		
		Page<Book> books = bookService.getBooks(pageable, category);
		
		model.addAttribute("books", books);
		
		return "bookpage";
	}
	
	@PostMapping("/")
	public String submitForm(@ModelAttribute BookQuery bookQuery, Model model) {
		Pageable pageable;
		if(bookQuery.isSort()) {
			pageable = PageRequest.of(0, 10, Direction.ASC, "book_depository_stars");
		}else {
			pageable = PageRequest.of(0, 10, Direction.ASC, "name");
		}
		
		Page<Book> books = bookService.getBooks(pageable, bookQuery.getCategory());
		
		model.addAttribute("books", books);
		
		return "bookpage";
	}
}
