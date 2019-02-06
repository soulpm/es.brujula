package es.brujula.dto;

import java.time.LocalDate;

import es.brujula.exception.BrujulaException;
import es.brujula.utility.ValidationUtility;

public class Professor extends Person {

	private String Department;
	private LocalDate CurrentTime;

	public Professor(String name, String surName, int yearOfBirth, String department) throws BrujulaException {
		setName(name);
		setSurName(surName);
		setYearOfBirth(yearOfBirth);
		getAge();
		setDepartment(department);
		
	}
	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) throws BrujulaException {
		ValidationUtility.validateText(department);
		Department = department;
	}
}
