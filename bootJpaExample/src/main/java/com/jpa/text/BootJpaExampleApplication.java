package com.jpa.text;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

import com.jpa.text.dao.UserRepository;
import com.jpa.text.entities.User;

@SpringBootApplication
public class BootJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootJpaExampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
//		User user =new User();
//		user.setName("pritesh Ingale");
//		user.setCity("Mumbai");
//		user.setStatus("I am a devloper");
//		
//		for saving single user
		// User user1=userRepository.save(user);
//		System.out.println(user1);

		// create object of user
		// save method for multiple object
		// creating multiple object

//		User user1 = new User();
//		user1.setName("priyanka Ingale");
//		user1.setCity("Mumbai");
//		user1.setStatus("I am a HR");
//
//		User user2 = new User();
//		user2.setName("akash Ingale");
//		user2.setCity("Mumbai");
//		user2.setStatus("I am a Manager");
//        
//		//for saving n no.of user
//		List<User> users =List.of(user1,user2);
//		//save multiple object
//		Iterable<User> result=userRepository.saveAll(users);
//		//for print in console 
//		result.forEach(user->{
//			System.out.println(user);
//		});
//		 

		// update the user with id 3
		// finding the user by id that i want to update

		// findById(id)-return the optional your data
//		Optional<User> optional = userRepository.findById(3);
//		// get the data
//		User user = optional.get();
//		// i have get the data now i am going to update the data that i want to change
//		user.setName("ashwini ingale");
//		user.setStatus("Makeup Artist");
//		User result = userRepository.save(user);
//		System.out.println(user);
//
//		// System.out.println(user);
//
//		// finding all user
//		Iterable<User> itr = userRepository.findAll();
////		itr.forEach(new Consumer<User>() {
////
////			@Override
////			public void accept(User t) {
////				System.out.println(t);
////				
////			}
////			
////		});
//		itr.forEach(User -> {
//			System.out.println(user);
//		});
//
//		// deleting the element
//		//userRepository.deleteById(3);
//	//	System.out.println("deleted");
//		
//		//find all the data
//		Iterable<User> allusers =userRepository.findAll();
//		allusers.forEach(User->System.out.println(user));
//		
//		//delete all
		// userRepository.deleteAll(allusers);

		/// finding the data by using derived method(custom method)
//		List<User> users=userRepository.findByNameAndCity("priyanka ingale","Mumbai");
//		users.forEach(e->System.out.println(e));
//		

		// creating our query by using jpql all user
		List<User> allUser = userRepository.getAllUser();
		allUser.forEach(e -> System.out.println(e));

		System.out.println("_______________________");

		// jpql query by using name
		List<User> userByName = userRepository.getUserByName("pritesh Ingale");
		userByName.forEach(e -> {
			System.out.println(e);
		});

		// native query
		System.out.println("__________________________________________________________________________");
		userRepository.getUsers().forEach(e -> System.out.println(e));
	}

}
