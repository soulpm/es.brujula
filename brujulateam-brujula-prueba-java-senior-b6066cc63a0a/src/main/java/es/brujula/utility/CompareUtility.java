package es.brujula.utility;

import java.util.Comparator;

import es.brujula.dto.Professor;

public class CompareUtility implements Comparator  {

	public int compare(Object o1, Object o2) {
        Professor professor1 = (Professor)o1;
        Professor professor2 = (Professor)o2; 
        return professor1.getSurName().
                compareTo(professor2.getSurName());
                
    }
}
