package com.datastructures.search;

public class FindFirstORLastOccurrence {

	/*
	 * Find a first and last occurence of the find element, in sorted array with duplicate elements
	 */
	//in general Binary search once we find the element we return the index. 
	// instead for first occurrence we need to adjust end to mid-1;
	//in last occuerrence we nee to adjust start to mid+1
	int findFirstOccurrence(int[] array, int x, int size){
		int start = 0;
		int end = size -1;
		int result = -1;
		while(start <= end){
			int mid = (start+end)/2;
			if(array[mid] == x){
				result = mid;
				end = mid-1;	//set end to mid-1
			}else if (array[mid] < x){
				start = mid+1;
			}else
				end = mid -1;
		}
		return result;
	}

	int findLastOccurrence(int[] array, int x, int size){
		int start = 0;
		int end = size -1;
		int result = -1;
		while(start <= end){
			int mid = (start+end)/2;
			if(array[mid] == x){
				result = mid;
				start = mid+1;		//set start to mid+1.				
			}else if (array[mid] < x){
				start = mid+1;
			}else
				end = mid -1;
		}
		return result;
	}

	public static void main(String[] args) {
		int []array = {1,2,4,5,5,6,7,8,9};
		FindFirstORLastOccurrence search = new FindFirstORLastOccurrence();
		int x = search.findFirstOccurrence(array, 5, array.length);
		System.out.println("first : "+x);
		x = search.findLastOccurrence(array, 5, array.length);
		System.out.println("last : "+x);
	}
	
}
