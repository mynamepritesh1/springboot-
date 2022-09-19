package com.Rest.etitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

public class Auther {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int auther_id;
	private String firstName;
	private String lastName;
	private String language;

	@OneToOne(mappedBy = "auther")
	//for break infinite loop it dosent give back 
	@JsonBackReference
	private Book book;

	public Auther() {
	}

	// getters and setters
	public int getAuther_id() {
		return auther_id;
	}

	public void setAuther_id(int auther_id) {
		this.auther_id = auther_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
