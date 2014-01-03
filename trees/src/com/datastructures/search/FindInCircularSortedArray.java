package com.datastructures.search;

public class FindInCircularSortedArray {

	/* assume no duplicates
	 * x=6
	 * 12,13,14,15,5,6,7,8
	 * mid 15.
	 * find x in given circularly sorted array.
	 * 
	 * 1. if array[mid] == x return index.
	 * 2. if array[mid] <= array[end]  which means right half is sorted
	 * 		then x > arrya[mid] && x <= array[end]
	 * 			start = mid+1;
	 *    else
	 * 			high = mid -1;
	 * 3. if array[mid] >= array[start]   which means left half is sorted	
	 * 	  then x >= array[start] && x < array[mid]
	 * 	   end = mid -1;
	 *    else
	 * 	   start = mid+1
	 */
	
	private int findXInCircularSortedArray(int[] array, int x, int size){
		int start = 0;
		int end = size-1;
		while(start <= end){
			int mid = (start + end)/2;
			if(array[mid] == x){
				return mid;
			}
			if(array[mid] <= array[end]){
				if(x > array[mid] && x<= array[end])
					start = mid+1;
				else
					end = mid -1;
			}else if (array[mid] >= array[start]){
				if(x >= array[start] && x < array[mid]){
					end = mid-1;
				}else
					start = mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {12,13,14,15,5,6,7,8};
		FindInCircularSortedArray find = new FindInCircularSortedArray();
		int x = find.findXInCircularSortedArray(array, 15, array.length);
		System.out.println(x);
	}
}
