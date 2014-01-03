package com.datastructures.sort;

public class SelectionSort{
	
	//Selection sort uses n^2/2 comparisons and n exchanges to sort an array of length N.
	//ALL : o(n^2)
    public static void selectionSort(Comparable[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i+1; j < size; j++) {
            	if(array[j].compareTo(array[min]) < 0){
            		min = j;
            	}
            }
            swap(array, i, min);
            printArray(array);
        }
    }

	private static void printArray(Comparable[] array){
		for (Comparable c : array) {
			System.out.print(c+" ");
		}
		System.out.println("\n");
	}
	/*
	 a:34,77,12,98,1,45,9
		1 77 12 98 34 45 9  (first min) 
		1 9 12 98 34 45 77  (next min)
		1 9 12 98 34 45 77 
		1 9 12 34 98 45 77 
		1 9 12 34 45 98 77 
		1 9 12 34 45 77 98 
		1 9 12 34 45 77 98 
	 
	 */

    private static void swap(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Integer[] a = {34,77,12,98,1,45,9};
        SelectionSort.selectionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}

