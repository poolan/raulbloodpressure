package com.example.raulbloodpressure.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // ASDF
public class Bloodpressure {

	@Id // ASDF
	@GeneratedValue(strategy = GenerationType.AUTO) // ASDF
	private Long id;
	private int upper;
	private int lower;
	private int pulse;
	private LocalDate measurementDate;
	// ALL THE ATTRIBUTES AND THEIR VALUE TYPES, ID IS A UNIQUE IDENTIFIER NUMBER OF
	// ONE UNIT OF INFORMATION, UPPER IS THE HIGHEST BLOODPRESSURE OF THE SAME UNIT,
	// LOWER IS THE LOWEST BLOODPRESSURE OF THAT UNIT, PULSE IS THE NUMBER OF TIMES
	// THE HEART BEAT EACH MINUTE, AND THE MEASUREMENTDATE IS THE TIME THE
	// MEASUEREMENT IS TAKEN, WHICH WILL BE THE LOCALDATE AT THAT CURRENT TIME

	public Bloodpressure() {
	}
	// ASDF

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
	// ASDF

}
