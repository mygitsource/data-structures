package com.datastructures.trees.easy;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class CheckTheExistenceOfPathWithGivenSum {

	static boolean isPathExists(Node root, int sum){
		if(root == null) return (sum == 0);
		
		sum = sum - root.getData();
		if(sum == 0){
			return true;
		}else{
			return (isPathExists(root.getLeft(), sum) || isPathExists(root.getRight(), sum));
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isPathExists(UtilTrees.getBinaryTree1(), 4));
	}
}
