package es.brujula.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import es.brujula.exception.BrujulaException;
import es.brujula.utility.PropertyUtility;

public class ActingProfessor  extends Professor{

	private LocalDate endDate;
	private static PropertyUtility property = new PropertyUtility();
	
	public ActingProfessor(String name, String surName, int yearOfBirth, String department,LocalDate endDate)throws BrujulaException  {
		super(name,surName,yearOfBirth,department);
		if(endDate.isBefore(LocalDate.now())) {throw new BrujulaException(property.getValueProperty("ERROR_FECHA_FIN"));}
		else { this.endDate = endDate;}
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	
	
	
}
