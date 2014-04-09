package com.datastructures.sort;

public class MergeSort {

	private void mergeSort(int array[]){
		int size = array.length;
		if(size < 2) return;
		
		//find mid element
		int mid = size/2;
		//divide the array into two parts , left array and right array.
		int[] larray = new int[mid];
		int[] rarray = new int[size-mid];
		//and copy the elements
		for(int i = 0; i <=mid-1; i++)
			larray[i] = array[i];
		
		for(int j = mid; j<=size-1;j++)
			rarray[j - mid] = array[j];	
		//call mergesort recursivly till size <2
		mergeSort(larray);
		mergeSort(rarray);
		
		//then merge arrays
		merge(larray, rarray, array);
	}
	
	private void merge(int[] larray, int[] rarray, int[] array){
		int lSize = larray.length;
		int rSize = rarray.length;
		//three indexes for three arrays
		int i =0, j =0, k =0;
		
		while(i < lSize && j < rSize){
			//compare left array with right array and copy to the element to original array
			if(larray[i] < rarray[j]){
				array[k] = larray[i];
				i++;
			}else{
				array[k] = rarray[j];
				j++;
			}
			k++;
		}
		
		while(i < lSize){
			array[k] = larray[i];
			i++;k++;
		}
		while(j < rSize){
			array[k] = rarray[j];
			j++;k++;
		}
	}
	
	public static void main(String[] args) {
		int[] test = {5,2,7,1,5,8,4,9,3};
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(test);
		for (int i : test) {
			System.out.println(i);
		}
	}
}
