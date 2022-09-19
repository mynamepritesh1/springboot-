package com.jpa.text.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.text.entities.User;
//create interface of UserRepository and then extends to crudRepository 
public interface UserRepository extends CrudRepository<User, Integer> {
	//used custome method 
	public List<User> findByName(String name);
	
	
	//finding the by using And
	
	public List<User> findByNameAndCity(String name,String city);
	
	
	//if we want to pass our query using JPQL QUERY
	//create a method and used a @query annotation and pass the query inside the annotation
	@Query("select u from User u ")
	public List<User> getAllUser();
	
	//passing the parameter using JPQL QUERY
	@Query("select u from User u WHERE u.name =:n")
	public List<User> getUserByName(@Param("n") String  name);
	
	//By usng Nativ Query
	
	@Query(value="select*from user", nativeQuery=true)
	public List<User> getUsers();
	
	
	
	
	

}
