package logic.util;

public class Validator {
	/*
	public static boolean template()
	{
		boolean valid = true;
		
		return valid;
	}
	 */
	public static boolean ci(String ci)
	{
		boolean valid = true;
		if(ci.length() == 11){
			for(int i = 0; i < ci.length() && valid; i++){
				if(!Character.isDigit(ci.charAt(i))){
					valid = false;
				}
			}
		} 
		else {
			valid = false;
		}
		return valid;
	}

	public static boolean alphabeticalString(String name)
	{
		boolean valid = true;
		for(int i = 0; i < name.length(); i++){
			if(!Character.isLetter(name.charAt(i))){
				valid = false;
			}
		}
		return valid;
	}
	
	public static boolean positiveNumber(Integer number)
	{
		return number > 0;
	}
	
	public static boolean resolution()
	{
		boolean valid = true;
		
		return valid;
	}
	
}