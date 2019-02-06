package es.brujula.dto;

import java.time.LocalDate;

import es.brujula.exception.BrujulaException;
import es.brujula.utility.PropertyUtility;

public class AssociatedProfessor extends Professor {

	private LocalDate startDate;
	private static PropertyUtility property = new PropertyUtility();
	
	
	public AssociatedProfessor(String name, String surName, int yearOfBirth, String department,LocalDate currentTime) throws BrujulaException {
		super(name,surName,yearOfBirth,department);
		this.startDate = startDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	
}
