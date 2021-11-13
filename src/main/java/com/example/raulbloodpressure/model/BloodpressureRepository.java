package com.example.raulbloodpressure.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BloodpressureRepository extends CrudRepository<Bloodpressure, Long> {
// CRUD stands for Create, Read, Update and Delete and it has all this functionalities. 
	List<Bloodpressure> findByid(Long id); 
	// findByid executes the line SELECT FROM Bloodpressure WHERE id= ""; the name of the method matter
}
