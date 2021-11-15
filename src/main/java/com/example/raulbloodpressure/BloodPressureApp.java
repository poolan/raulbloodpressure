package com.example.raulbloodpressure;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.raulbloodpressure.model.Bloodpressure;
import com.example.raulbloodpressure.model.BloodpressureRepository;


@SpringBootApplication

public class BloodPressureApp {
	// Logger is final because we just need one and there is no need to alter it. 
	private static final Logger log = LoggerFactory.getLogger(BloodPressureApp.class);
	// we only need one logger in the app. No need to alter log settings
	
	public static void main(String[] args) {
		SpringApplication.run(BloodPressureApp.class, args);
	}
	// Execution starts from this main method

	@Bean
	public CommandLineRunner bloodDemo(BloodpressureRepository repository) {
		return (args) -> {
			log.info("save some bloodpressures");
			repository.save(new Bloodpressure(95, 70, 70, LocalDate.of(2021, 5, 15)));
			repository.save(new Bloodpressure(102, 80, 81, LocalDate.of(2021, 8, 21)));
			repository.save(new Bloodpressure(93, 65, 68, LocalDate.of(2021, 10, 01)));
			// here we code some data for the db and add it. This rows will show by default from the beginning by adding them
			// to the log.
			
			log.info("fetch all blood pressures");
			for (Bloodpressure bloodpressure : repository.findAll()) {
				log.info(bloodpressure.toString());
			}
			// this is to display the info of our blood pressure records into a string in the console.

		};
	}
}
