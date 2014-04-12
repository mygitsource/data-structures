package com.datastructures.trees.bt;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class HasPathSum {

	//check the existence of path with given sum
	
	static boolean hasPathSum(Node root, int sum){
		if(root == null) {
			return (sum == 0);
		}
		//subtract the sum with node's data.
		sum = sum - root.getData();
		boolean left = hasPathSum(root.getLeft(), sum);
		boolean right = hasPathSum(root.getRight(), sum);
		return (left || right);
	}
	
	public static void main(String[] args) {
		boolean val = hasPathSum(UtilTrees.getBinaryTree1(), 9);
		System.out.println(val);
	}
	
}
