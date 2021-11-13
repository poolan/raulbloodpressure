package com.example.raulbloodpressure.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // represents a table in a relational db
@Table(name="MyRecords") // annotation to rename the table; also is possible to change column names with @Column (name="");
public class Bloodpressure {
	@Id // primary key of the table
	@GeneratedValue(strategy = GenerationType.AUTO) // auto increments the value of the id (pk) everytime we insert a new value 
	private Long id;
	private int upper, lower, pulse;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate measurementDate;
	// ALL THE ATTRIBUTES AND THEIR VALUE TYPES, ID IS A UNIQUE IDENTIFIER NUMBER OF
	// ONE UNIT OF INFORMATION, UPPER IS THE HIGHEST BLOODPRESSURE OF THE SAME UNIT,
	// LOWER IS THE LOWEST BLOODPRESSURE OF THAT UNIT, PULSE IS THE NUMBER OF TIMES
	// THE HEART BEAT EACH MINUTE, AND THE MEASUREMENTDATE IS THE TIME THE
	// MEASUEREMENT IS TAKEN, WHICH WILL BE THE LOCALDATE AT THAT CURRENT TIME

	public Bloodpressure() {
	}
	

	public Bloodpressure(int upper, int lower, int pulse, LocalDate measurementDate) {
		super();
		this.upper = upper;
		this.lower = lower;
		this.pulse = pulse;
		this.measurementDate = measurementDate;
	}
	// THE CONSTRUCTOR

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUpper() {
		return upper;
	}

	public void setUpper(int upper) {
		this.upper = upper;
	}

	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public LocalDate getMeasurementDate() {
		return measurementDate;
	}

	public void setMeasurementDate(LocalDate measurementDate) {
		this.measurementDate = measurementDate;
	}
	// GETTERS AND SETTERES GENERATED AUTOMATICALLY FROM SOURCE WINDOW

	@Override
	public String toString() {
		return "BloodPressure [id=" + id + ", upper=" + upper + ", lower=" + lower + ", pulse=" + pulse
				+ ", measurementDate =" + measurementDate + "]";
	}
	

}
