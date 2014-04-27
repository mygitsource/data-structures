package com.datastructures.strings;

import java.util.Arrays;

public class Anagram {

	/* This method prints all anagrams of a obtained by leaving the first 
	   i characters unchanged and going through all possible orderings of 
	   characters i and beyond. For example:
	   makeAnagram("abc", 1) prints out abc acb 
	   makeAnagram("abc", 0) prints out abc acb bac bca cab cba
	   makeAnagram("abcd", 2) prints out abcd abdc
	*/
	static void makeAnagram(char[] a, int i) {
		//System.out.println("MakeAnagram i=" + i); //for debug
		if (i == a.length-1)  printArray(a);
		else {
			for (int j=i; j< a.length; j++) {
				//swap a[i] with a[j]
				char c = a[i]; 
				a[i] = a[j]; 
				a[j] = c;
				makeAnagram(a, i+1);
//				//swap back
//				c = a[i]; 
//				a[i] = a[j]; 
//				a[j] = c;
			}
		}
	}//end of makeAnagram
	
	//print an array
	static void printArray(char [] a) {
		System.out.println(Arrays.toString(a));
	}
	
	public static void main(String[] args) {
		makeAnagram("abc".toCharArray(), 0);
	}

}
