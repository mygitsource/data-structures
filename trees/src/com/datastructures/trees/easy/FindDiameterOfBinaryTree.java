package com.datastructures.trees.easy;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

//Width
public class FindDiameterOfBinaryTree {

	static int findDiameterOfBinaryTree(Node root, Diameter diameter){
		if(root == null) return 0;
		
		int left = findDiameterOfBinaryTree(root.getLeft(), diameter);
		int right = findDiameterOfBinaryTree(root.getRight(), diameter);
		
		if((left + right) > diameter.diameter){
			//+1 is req?
			diameter.diameter = (left + right) +1;
		}
		return Math.max(left, right)+1;
	}
	
	static class Diameter{
		int diameter;
		
		@Override
		public String toString() {
			return Integer.toString(diameter);
		}
	}
	
	public static void main(String[] args) {
		Diameter diameter =  new Diameter();
		findDiameterOfBinaryTree(UtilTrees.getBinaryTree4(), diameter);
		System.out.println(diameter);
	}
}
