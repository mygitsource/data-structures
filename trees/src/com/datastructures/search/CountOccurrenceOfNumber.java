package com.datastructures.search;

/**
 *	Count occurrences of number in given sorted array with duplicates  
 *
 */
public class CountOccurrenceOfNumber {

	private int countNumberOfOccurrences(int array[], int find){
		FindFirstORLastOccurrence occurrence = new FindFirstORLastOccurrence();
		int first = occurrence.findFirstOccurrence(array, find, array.length);
		int last = occurrence.findLastOccurrence(array, find, array.length);
		return (last-first)+1;
	}
	
	public static void main(String[] args) {
		int[] array = {2,3,4,5,6,7,8,8,8,8,9,10,11};
		CountOccurrenceOfNumber counter = new CountOccurrenceOfNumber();
		System.out.println(counter.countNumberOfOccurrences(array, 8));
	}
}
