package com.datastructures.search;

public class BinarySearch {

	private int binarySearch(int[] array, int x, int size){
		int start = 0;
		int end = size -1;
		while(start <= end){
			int mid = (start+end)/2;
			if(array[mid] == x){
				return mid;				
			}else if (array[mid] < x){
				start = mid+1;
			}else
				end = mid -1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int []array = {1,2,4,5,6,7,8,9};
		BinarySearch search = new BinarySearch();
		int x = search.binarySearch(array, 8, array.length);
		System.out.println(x);
		x = search.binarySearchRecursive(array, 8, 0, array.length-1);
		System.out.println(x);
	}
	
	private int binarySearchRecursive(int[] array, int x, int start, int end){
		if(!(start <= end)) return -1;
		int mid = (start+end)/2;
		if(array[mid] == x){
			return mid;
		}
		if(array[mid] < x){
			return binarySearchRecursive(array, x, mid+1, end);
		}else{
			return binarySearchRecursive(array, x, start, mid-1);
		}
	}
}
