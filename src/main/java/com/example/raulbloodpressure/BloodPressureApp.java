package com.example.raulbloodpressure;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.raulbloodpressure.model.Bloodpressure;
import com.example.raulbloodpressure.model.BloodpressureRepository;

import fi.haagahelia.course.domain.Student;
import fi.haagahelia.course.domain.StudentRepository;

@SpringBootApplication // ASDF
public class BloodPressureApp {

	public static void main(String[] args) {
		SpringApplication.run(BloodPressureApp.class, args);
	}

	@Bean
	public CommandLineRunner bloodDemo(BloodpressureRepository repository) {
		return (args) -> {
			log.info("save some bloodpressures");
			repository.save(new Bloodpressure(95, 70, 70, LocalDate.of(2021, 5, 15)));
			repository.save(new Bloodpressure(102, 80, 81, LocalDate.of(2021, 8, 21)));
			repository.save(new Bloodpressure(93, 65, 68, LocalDate.of(2021, 10, 01)));

			log.info("fetch all students");
			for (Bloodpressure bloodpressure : repository.findAll()) {
				log.info(bloodpressure.toString());
			}

		};
	}
}
