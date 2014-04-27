package com.datastructures.sort;

public class QuickSortSet3 {

	
	public static void basicQuickSort1(long arr[], int beginIdx, int len) {
	    if ( len <= 1 )
	         return;
	    
	    final int endIdx = beginIdx+len-1;

	    // Pivot selection
	    final int pivotPos = beginIdx+len/2;
	    final long pivot = arr[pivotPos];
	    swap(arr, pivotPos, endIdx);

	    // partitioning
	    int p = beginIdx;
	    for(int i = beginIdx; i != endIdx; ++i) {
	         if ( arr[i] <= pivot ) {
	             swap(arr, i, p++);
	         }
	     }
	     swap(arr, p, endIdx);

	     // recursive call
	     basicQuickSort1(arr, beginIdx, p-beginIdx);
	     basicQuickSort1(arr, p+1,  endIdx-p);
	}
	
	public static void basicQuickSort2(long arr[], int beginIdx, int len) {
	    if ( len <= 1 )
	        return;
	 
	    final int endIdx = beginIdx + len - 1;
	    final int pivotIdx = getPivotIdx(arr, beginIdx, len);
	    final long pivot = arr[pivotIdx];

	    swap(arr, pivotIdx, endIdx);
	    int p = partition(arr, beginIdx, len, pivot);
	    swap(arr, p, endIdx);

	    basicQuickSort2(arr, beginIdx, p-beginIdx);
	    basicQuickSort2(arr, p+1,  endIdx-p); 
	}  

	public static int partition(long[] arr, int beginIdx, int len, long pivot) {
	     final int endIdx = beginIdx + len - 1;
	     int p = beginIdx;
	     for(int i = beginIdx; i != endIdx; ++i) {
	         if ( arr[i] <= pivot ) {
	             swap(arr, i, p++);         
	         }     
	     }     
	     return p;
	}

	public static int getPivotIdx(long arr[], int beginIdx, int len) {
	     return beginIdx+len/2;
	}
	
	static void swap(long[] array, int ind1, int ind2){
		long temp = array[ind1];
		array[ind1] = array[ind2];
		array[ind2] = temp;
	}
	
}
