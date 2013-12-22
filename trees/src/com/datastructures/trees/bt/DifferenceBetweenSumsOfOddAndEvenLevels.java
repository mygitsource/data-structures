package com.datastructures.trees.bt;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

/**
 * Difference between sums of odd level and even level nodes of a Binary Tree
 * Given a a Binary Tree, find the difference between the sum of nodes at odd level and 
 * the sum of nodes at even level.
 *  
 * Consider root as level 1, left and right children of root as level 2 and so on
 * 
 * @author ravi
 */

public class DifferenceBetweenSumsOfOddAndEvenLevels {

	static int evenSum = 0;
	static int oddSum = 0;
	public static int differenceBetweenSumsOfOddAndEvenLevels(Node root, int level){
		if(root == null) return 0;
		
		if((level%2) == 1){
			oddSum = oddSum+root.getData();
		}else{
			evenSum = evenSum+root.getData();
		}
		
		differenceBetweenSumsOfOddAndEvenLevels(root.getLeft(), level+1);
		differenceBetweenSumsOfOddAndEvenLevels(root.getRight(), level+1);
		
		return (oddSum - evenSum);
	}
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree1();
		int diff = differenceBetweenSumsOfOddAndEvenLevels(root, 1);
		System.out.println(diff);
	}
}
