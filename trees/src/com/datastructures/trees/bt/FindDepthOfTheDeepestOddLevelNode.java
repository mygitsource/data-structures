package com.datastructures.trees.bt;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

//http://www.geeksforgeeks.org/find-depth-of-the-deepest-odd-level-node/

public class FindDepthOfTheDeepestOddLevelNode {
	static int leafLevel = 0;
	static Node leafNode = null;
	public static int findDepthOfTheDeepestOddLevelNode(Node node, int level){
		if(node == null) return 0;
		
		if(node.getLeft() == null){
			if((level%2 ==1) && (level > leafLevel)){
				leafLevel = level;
				leafNode = node;
				System.out.println("Leaf Leavel :"+leafLevel);
			}
		}
		findDepthOfTheDeepestOddLevelNode(node.getLeft(), level+1);
		findDepthOfTheDeepestOddLevelNode(node.getRight(), level+1);
		//return leafNode data
		return leafNode.getData();
	}
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree1();
		int data = findDepthOfTheDeepestOddLevelNode(root, 1);
		System.out.println(data);
	}
	
}
