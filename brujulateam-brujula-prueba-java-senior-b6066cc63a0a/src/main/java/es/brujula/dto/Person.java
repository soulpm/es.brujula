package es.brujula.dto;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import es.brujula.exception.BrujulaException;
import es.brujula.utility.PropertyUtility;
import es.brujula.utility.ValidationUtility;

public class Person{
	public String Name;
	public String SurName;
	public int YearOfBirth;
	private PropertyUtility property = new PropertyUtility();
	public String getName() {
		return Name;
	}
	public void setName(String name) throws BrujulaException {
		ValidationUtility.validateText(name);
		Name = name;
	}
	public String getSurName() {
		return SurName;
	}
	public void setSurName(String surName) throws BrujulaException {
		ValidationUtility.validateText(surName);
		SurName = surName;
	}
	public int getYearOfBirth() {
		return YearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		YearOfBirth = yearOfBirth;
	}
	public  String getCompleteName() throws BrujulaException  {
		return this.getSurName()+", "+this.getName();
	}
	public int getAge() throws BrujulaException  {
		int currentYear = LocalDate.now().getYear();
		if(currentYear-this.YearOfBirth<18) {throw new BrujulaException(property.getValueProperty("ERROR_EDAD"));}
		return currentYear-this.YearOfBirth;
	}
	
}
