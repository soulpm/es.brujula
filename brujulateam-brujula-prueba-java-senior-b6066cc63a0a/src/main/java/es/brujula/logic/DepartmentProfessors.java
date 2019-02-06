package es.brujula.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.brujula.dto.Professor;
import es.brujula.exception.BrujulaException;
import es.brujula.utility.CompareUtility;
import es.brujula.utility.PropertyUtility;

public class DepartmentProfessors {
	private String DepartmentName;
	private List<Professor> listProfessor;
	private PropertyUtility property = new PropertyUtility();
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public DepartmentProfessors(String department) {
		this.DepartmentName = department;
	}
	public List<Professor> list(){
		Collections.sort(listProfessor,new CompareUtility());
		return listProfessor;
	}
	
	public void addProfessor(Professor professor)  throws BrujulaException{
		if(listProfessor == null) {this.listProfessor = new ArrayList<Professor>();}
		int validateValue = validateProffessor(professor);
		switch(validateValue) {
			case 0:
				listProfessor.add(professor);
			break;
			case 1:
			throw new BrujulaException(property.getValueProperty("ERROR_DEPARTMENT_EQUALS"));
			case 2:
			throw new BrujulaException(property.getValueProperty("ERROR_PROFESSOR_DUPLICY"));
		}
	}
	
	private int validateProffessor(Professor item) {
		int valor = 0;
		if(!getDepartmentName().equals(item.getDepartment())) {
			valor = 1;
		}
		else {
			for(Professor entityList:listProfessor) {
				if(entityList.getName().equals(item.getName()) && entityList.getSurName().equals(item.getSurName())) {
					valor = 2;
					break;
				}
			}
		}
		return valor;
	}
	
	
  
  
}
