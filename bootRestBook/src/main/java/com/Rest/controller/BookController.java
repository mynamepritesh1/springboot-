package com.Rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Rest.etitites.Book;
import com.Rest.services.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	// getting all book handler
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {

//for giving not found error in o/p if there is not any books in our system then it throw the error
		List<Book> list = this.bookService.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	// getting single book by id Handler
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		if (book == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

		return ResponseEntity.of(Optional.of(book));

	}

	// create the data handler
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		try {
			b = this.bookService.addBook(book);
			return ResponseEntity.of(Optional.of(book));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}

	}

	// delete the data Handler
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<?>deleteBook(@PathVariable("bookId") int bookid) {
        try {

    		this.bookService.deleteBook(bookid);
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}

	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookid) {
		try {
			this.bookService.updateBook(book, bookid);
			return ResponseEntity.ok().body(book);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
		
	

	}

}
