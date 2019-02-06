package es.brujula.utility;

import es.brujula.exception.BrujulaException;

public class ValidationUtility {
	
	private static PropertyUtility property = new PropertyUtility();
	
	public static boolean isValidLength(String input) {
		return (input.length()<=20);
	}
	public static boolean isEmpty(String input) {
		return (input.equals(""));
	}
	
	public static void validateText(String input) throws BrujulaException
	{
		if(!ValidationUtility.isValidLength(input) || ValidationUtility.isEmpty(input)) {
			throw new BrujulaException(property.getValueProperty("ERROR_TEXT_NOT_VALID"));
		}
	}
	
}
