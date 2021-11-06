package com.example.raulbloodpressure;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.raulbloodpressure.model.Bloodpressure;
import com.example.raulbloodpressure.model.BloodpressureRepository;

import fi.haagahelia.course.domain.Student;
import fi.haagahelia.course.domain.StudentRepository;

@SpringBootApplication //ASDF
public class BloodPressureApp {

	public static void main(String[] args) {
		SpringApplication.run(BloodPressureApp.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(BloodpressureRepository repository) {
		return (args) -> {
			log.info("save a couple of students");
			repository.save(new Bloodpressure("John", "Johnson", "john@john.com"));
			repository.save(new Bloodpressure("Katy", "Kateson", "kate@kate.com"));	
			
			log.info("fetch all students");
			for (Bloodpressure bloodpressure : repository.findAll()) {
				log.info(bloodpressure.toString());
			}

		};
	}
}
