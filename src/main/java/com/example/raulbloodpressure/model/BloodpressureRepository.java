package com.example.raulbloodpressure.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BloodpressureRepository extends CrudRepository<Bloodpressure, Long> {

	List<Bloodpressure> findByid(Long id);
}
