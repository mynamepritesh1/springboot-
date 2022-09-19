package com.Rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.Rest.etitites.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	

}
