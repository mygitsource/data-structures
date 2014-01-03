package com.datastructures.trees.bt;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class CheckALLLeavesAtSameLevel {

	/**
	 * Given a Binary Tree, check if all leaves are at same level or not.
	 * http://www.geeksforgeeks.org/check-leaves-level/
	 * 
	 */
	static int leafLevel = 0;
	private static boolean isAllleavesAtSameLeavel(Node node, int level){
		if(node == null) return true;
		if(node.getLeft() == null && node.getRight() == null){
			//set first time, when you got first leaf.
			if(leafLevel == 0){
				leafLevel = level;
				return true;
			}
			
			return (leafLevel == level); 
		}
		
		return (isAllleavesAtSameLeavel(node.getLeft(),level+1) && isAllleavesAtSameLeavel(node.getRight(), level+1));
	} 	
	
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree5();
		boolean sameLevel = isAllleavesAtSameLeavel(root, 1 );
		System.out.println(sameLevel);
	}
}
