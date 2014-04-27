package com.datastructures.sort;

/*
 * 1)  Start with list I of n items
2)  Choose pivot v from I
3)  Partition I into 2 unsorted lists I1 and I2 such that
        I1 : all keys smaller than pivot
        I2 : all keys larger than pivot
        Items same as pivot goes to either list
4)  Sort I1 recursively, yielding sorted list S1
5)  Sort I2 recursively, yielding sorted list S2
6)  Concatenate S1,v,S2 yielding sorted list S
 */

public class QuickSort {

	private void quickSort(int[] array, int startIdx, int endIdx ){
		if(startIdx < endIdx){		// or if(startIdx >=endIdx) return;
			int pIndex = partition(array, startIdx, endIdx);
			quickSort(array, startIdx, pIndex-1);  // sub array start to pindex-1		
			quickSort(array, pIndex+1, endIdx);   //sub arrat pindex+1 to end
		}
		
	}
	/*
	 * lets say pivot is end element,
	 * traverse the array and if the value is lessthen the pivot, 
	 * move the value the start of the array and increment the starting position (pIndex). 
	 */
	private int partition(int[] array, int startIdx, int endIdx){
		//can be any element , lets say start element
	 	int pivot = array[endIdx];
	 	//partition index = start index
	    int pIndex = startIdx;			
	 
	    for (int i = startIdx; i<endIdx; i++) {
	    	//swap if the element is less the pivot
	        if(array[i] <= pivot) {		
	            swap(array, i, pIndex);
	            pIndex++;
	        }
	    }
	  //swap partition element(pivot) with pindex.
	    swap(array, pIndex, endIdx);		
	    return pIndex;
	}
	
	private void swap(int[] array, int ind1, int ind2){
		int temp = array[ind1];
		array[ind1] = array[ind2];
		array[ind2] = temp;
	}
	
	public static void main(String[] args) {
		int []array = {34,12,51,7,78,23,7,12,6};
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(array, 0, array.length-1);
		for (int i : array) {
			System.out.println(i);
		}
	}
}
