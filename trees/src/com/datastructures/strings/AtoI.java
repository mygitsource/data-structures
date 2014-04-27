package com.datastructures.strings;

public class AtoI {

	static int aToi(String string){
		if(string == null || string.length() == 0) {throw new NumberFormatException(string);}
		
		int sign = 1;
		int result = 0;
		
		char[] chars = string.toCharArray();
		int index = 0;
		if(chars[0] == '-'){
			index++;
			sign = -1;
		}else if(chars[0] == '+'){
			index++;
		}
		
		for (int i = index; i < chars.length; i++) {
			result = result*10+Character.getNumericValue(chars[i]);
		}
		return sign*result;
	}

	public static void main(String[] args) {
		System.out.println(aToi("+3344"));
	}
}
