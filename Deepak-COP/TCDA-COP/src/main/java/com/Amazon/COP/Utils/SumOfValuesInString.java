package com.Amazon.COP.Utils;

// As the values in the column are like "20 +5" ; "45+5" in string format we use this to add them and return the final sum
 
public class SumOfValuesInString {
	
	public Integer SumOfNumbers(String str) {
		String temp = ""; 
		int sum = 0; 
		for(int i = 0; i < str.length(); i++) 
		{ 
			char ch = str.charAt(i); 
			if (Character.isDigit(ch)) 
				temp += ch; 
			else
			{ 
				sum += Integer.parseInt(temp); 
				temp = "0"; 
			} 
		} 
		return sum + Integer.parseInt(temp); 
}


}
