package com.datastructures.strings;

import java.util.Arrays;

public class ArraySort {

	static String []strings = {"A1","B1","A1","B1","A1","B1","A1","B1","B1","A1"};
//	static String []strings = {"A1","A1","A1","A1","B1","B1","B1","B1","B1","B1"};
	static int count;
	static void stringSort(){
		
		for (int i = 1; i < strings.length; i++) {
			String str = strings[i];
			int j = i;
			for (;j >0 && strings[j -1].compareToIgnoreCase(str) < 0; j--) {
				strings[j] = strings[j -1];
			}
			strings[j] = str;
//			System.out.println(Arrays.toString(strings));
		}
	}
	
	
	static void insertionSort(int[] array){
		if(array.length == 0 || array.length ==1) return ;
		
		for (int i = 1; i < array.length; i++) {
			int tmp = array[i];
			int j = i;
			for (; j > 0 && array[j-1] > tmp; j--) {
				array[j] = array[j-1];
			}
			array[j] = tmp;
		}
		System.out.println(Arrays.toString(array));
	}
	
	
	public static void main(String[] args) {
		stringSort();
//		System.out.println(Arrays.toString(strings));
		insertionSort(new int[]{4,53,5,2234,4,5,55,123,56,355,332});
	}
	
}
