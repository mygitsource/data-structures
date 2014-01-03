package com.datastructures.sort;

public class MergeSort {

	private void mergeSort(int array[]){
		int size = array.length;
		if(size < 2) return;
		
		int mid = size/2;
		int[] larray = new int[mid];
		int[] rarray = new int[size-mid];
		for(int i = 0; i <=mid-1; i++)
			larray[i] = array[i];
		for(int j = mid; j<=size-1;j++)
			rarray[j - mid] = array[j];	
		
		mergeSort(larray);
		mergeSort(rarray);
		merge(larray, rarray, array);
	}
	
	private void merge(int[] larray, int[] rarray, int[] array){
		int lSize = larray.length;
		int rSize = rarray.length;
		int i =0, j =0, k =0;
		
		while(i <lSize && j < rSize){
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
