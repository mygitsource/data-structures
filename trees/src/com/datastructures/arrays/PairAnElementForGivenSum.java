package com.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

public class PairAnElementForGivenSum {

	//http://www.geeksforgeeks.org/find-if-there-is-a-triplet-in-bst-that-adds-to-0/
	public void pairAnElement(int []array, int sum){
		Map<Integer, Byte> map = new HashMap<>();
		Byte on = 1;
		for (int i = 0; i < array.length; i++) {
			int temp = sum - array[i];
			//check the difference element exists in the map.
			if(map.get(temp) == on){
				System.out.println("Pair an element : "+array[i]+"  Sum: "+sum+"  temp: "+temp);
			}
			map.put(array[i], on);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1, 4, 45, 10, 6, 8};
		PairAnElementForGivenSum pair = new PairAnElementForGivenSum();
		pair.pairAnElement(array, 16);
	}
}
