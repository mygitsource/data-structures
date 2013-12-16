package com.datastructures.trees.bt;

import com.datastructures.trees.util.StaticTrees;
import com.datastructures.trees.util.Util;

public class LevelOrderExample {

	public static void main(String[] args) {
		//Util.levelOrderTraversal(StaticTrees.getBinaryTree1());
		Util.levelOrderTraversalUsingHeight(StaticTrees.getBinaryTree1());
	}
}
