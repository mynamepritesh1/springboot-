package com.Rest.etitites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Auther auther;
	
	
	public Book() {
		super();
	
		
		
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", auther=" + auther + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Auther getAuther() {
		return auther;
	}


	public void setAuther(Auther auther) {
		this.auther = auther;
	}


	public Book(int id, String title, Auther auther) {
		super();
		this.id = id;
		this.title = title;
		this.auther = auther;
	}
	
	

}
