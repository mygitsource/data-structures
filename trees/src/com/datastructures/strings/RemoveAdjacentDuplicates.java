package com.datastructures.strings;

public class RemoveAdjacentDuplicates {

	//geeksforgeeg -- > gksfor
	//Not yet finished
	static String removeAdj(String src, char lastRemoved, char lastOcc) {
		if(src == null) return null;
		
		if(src.length() == 1) return src;
		
		if(src.charAt(0) == src.charAt(1)){
			while (src.charAt(0) == src.charAt(1)){
				src = src.substring(1);
			}
			return removeAdj(src.substring(1), src.charAt(0), lastOcc);
		}else if(lastRemoved == src.charAt(0)){
			while (src.charAt(0) == src.charAt(1)){
				src = src.substring(1);
			}
			return removeAdj(src.substring(1), src.charAt(0), lastOcc);
		}else if(lastOcc == src.charAt(0)){
			while (src.charAt(0) == src.charAt(1)){
				src = src.substring(1);
			}
			return removeAdj(src.substring(1), src.charAt(0), lastOcc);
		}else{
			return src.charAt(0)+removeAdj(src.substring(1), '\0',  src.charAt(0));
		}
	}

	public static void main(String [] args) {
		String string = removeAdj("geeksforgeeg", '\0', '0');
		System.out.println(string);
	}
}


