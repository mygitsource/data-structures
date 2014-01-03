package com.datastructures.sort;

public class InsertionSort {

	private static void insertionSort(int []comp){
		int size = comp.length;
		//start with 1
		for(int i=1; i < size; i++){
			for(int j = i; j > 0 && comp[j] < comp[j-1];j--){
				int temp = comp[j-1];
				comp[j-1] = comp[j];
				comp[j] = temp;
			}
			//printArray(comp);
		}
	}
/*
 * 
 *a: 9,8,7,6,5,4,3,2
 
	8 9 7 6 5 4 3 2		(i = 1 :: j 1 - 0)	
	7 8 9 6 5 4 3 2		(i = 2 :: j 2 - 0)
	6 7 8 9 5 4 3 2	
	5 6 7 8 9 4 3 2	
	4 5 6 7 8 9 3 2	
	3 4 5 6 7 8 9 2	
	2 3 4 5 6 7 8 9 
 */
	
	private static void printArray(int[] array){
		for (int i : array) {
			System.out.print(i+" ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2};
        InsertionSort.insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
	}
}
