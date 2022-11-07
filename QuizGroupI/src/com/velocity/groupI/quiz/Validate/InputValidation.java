package com.velocity.groupI.quiz.Validate;

import com.velocity.groupI.quiz.exception.InvalidNameException;
import com.velocity.groupI.quiz.exception.InvalidOptionException;

public class InputValidation {
	
	public void validateStringInput(String s) 
	{
		boolean flag = true;
		for(int i=0;i<s.length();i++)
		{
			char ch =s.charAt(i);
			if (!(ch >= 'a' && ch <= 'z') && !(ch >= 'A' && ch <= 'Z')) {
	            flag =false;
	         }
		}
		
		if(flag==false) {
			try {
				throw new InvalidNameException("Entered Name is not valid. Please Enter Characters Only ");
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	public void validateNumberInput(int number) 
	{
		
		
		if(number<1 || number>4) {
			try {
				throw new InvalidOptionException("Entered option is not valid. Please Enter Proper Option Number within Range 1 to 4 ");
			} catch (InvalidOptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
