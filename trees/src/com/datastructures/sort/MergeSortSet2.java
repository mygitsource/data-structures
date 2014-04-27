package com.datastructures.sort;

import java.util.Arrays;

public class MergeSortSet2 {

	static void sort(int start, int length, int[] uSorted){
		if(length > 2){
			int xLength = (int)Math.floor(length/2);
			int yLength = length - xLength;
			sort(start, xLength, uSorted);
			sort(start+xLength, yLength, uSorted);
			merge(start, xLength, start+xLength, yLength, uSorted);
		}else{
			 int e = uSorted[start + 1];
	            if ((e - start) < 0) {
	                uSorted[start + 1] = uSorted[start];
	                uSorted[start] = e;
	            }
			
		}
	}
	
	static void merge(int xStart, int xLength, int yStart, int yLength, int[] uSorted){
		 	int count = 0;
	        int[] output = new int[xLength + yLength];
	        int i = xStart;
	        int j = yStart;
	        int aSize = xStart + xLength;
	        int bSize = yStart + yLength;
	        while (i < aSize || j < bSize) {
	            Integer a = null;
	            if (i < aSize) {
	                a = uSorted[i];
	            }
	            Integer b = null;
	            if (j < bSize) {
	                b = uSorted[j];
	            }
	            if (a != null && b == null) {
	                output[count++] = a;
	                i++;
	            } else if (b != null && a == null) {
	                output[count++] = b;
	                j++;
	            } else if ((b -a) <= 0) {
	                output[count++] = b;
	                j++;
	            } else {
	                output[count++] = a;
	                i++;
	            }
	        }
	        int x = 0;
	        int size = xStart + xLength + yLength;
	        for (int y = xStart; y < size; y++) {
	            uSorted[y] = output[x++];
	        }		
	}
	
	
	public static void main(String[] args) {
		int[] ary = new int[]{4,5,6,73,2,57,32,478,1246,23,56,8};
		sort(0, ary.length, ary);
		System.out.println(Arrays.toString(ary));

	}
}
