package com.example.raulbloodpressure.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUsername(String username);
	
	List<User> findByRole(String role);

}
