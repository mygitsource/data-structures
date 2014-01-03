package com.datastructures.search;

public class ArrayRotationCount {

	/*
	 * Assuming there is no duplicates
	 * In circularly sorted array number of rotations is the index of minimal element.
	 * 
	 * 1. if array is sorted then the minimal will be the starting.
	 * 2. otherwise mid will grater then previous and next
	 * 3. else it would be sorted from mid to end
	 * 		array[mid] <= array[end]
	 * 4. or it would be started from start.
	 *      array[mid] >= array[low]
	 */
	
	private int rotationCount(int[] array){
		int size = array.length;
		int start = 0;
		int end = size -1;
		while(start <= end){
			if(array[start] <= array[end]){
				return start;
			}
			int mid = (start+end)/2;
			int prev = (mid+size-1)%size;
			int next = (mid+1)%size;
			if(array[mid] <= array[next] && array[mid] <= array[prev]){
				return mid;				
			}else if(array[mid] <= array[end]){
				end = mid-1;
			}else if(array[mid] >= array[start]){
				start = mid +1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int []array = {7,8,9,1,2,3,4,5,6};
		ArrayRotationCount count = new ArrayRotationCount();
		System.out.println(count.rotationCount(array));
	}
}
