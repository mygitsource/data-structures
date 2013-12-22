package com.datastructures.trees.bt;

import com.datastructures.trees.util.UtilTrees;
import com.datastructures.trees.util.Util;

public class LevelOrderExample {

	public static void main(String[] args) {
		//Util.levelOrderTraversal(StaticTrees.getBinaryTree1());
		Util.levelOrderTraversalUsingHeight(UtilTrees.getBinaryTree1());
	}
}
