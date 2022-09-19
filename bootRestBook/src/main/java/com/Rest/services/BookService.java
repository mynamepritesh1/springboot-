package com.Rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Rest.dao.BookRepository;
import com.Rest.etitites.Book;

@Component
public class BookService {
	@Autowired
	private BookRepository bookRepository;
//	private static List<Book> list = new ArrayList<>();
//	static {
//		list.add(new Book(12, "Rich dad poor dad", "abc"));
//		list.add(new Book(13, "Python refrence book", "xyz"));
//		list.add(new Book(14, "DSA Boook", "lmn"));
//		list.add(new Book(15, "Java Full Cource", "efg"));
//	}

	// get all the book
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	// get single book by id
	public Book getBookById(int id) {
		Book book = null;
		try {
			//book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;

	}

	// adding the book
	public Book addBook(Book book) {
	//	list.add(book);
		Book result=bookRepository.save(book);
		
		return result;
	}

	// delete the book
	public void deleteBook(int bid) {

		//list = list.stream().filter(e -> e.getId() != bid).collect(Collectors.toList());
		bookRepository.deleteById(bid);
		

	}

	// update the book
	public void updateBook(Book book, int bookId) {
//	//	list = list.stream().map(e -> {
//		
//			if (e.getId() == bookId) {
//				e.setTitle(book.getTitle());
//				e.setAuther(book.getAuther());
//			}
//			return e;
//
//		}).collect(Collectors.toList());
		book.setId(bookId);
		bookRepository.save(book);

	}

}
