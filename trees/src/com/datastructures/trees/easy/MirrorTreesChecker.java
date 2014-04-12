package com.datastructures.trees.easy;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class MirrorTreesChecker {

	static boolean areMirrorTrees(Node root1, Node root2){
		if(root1 == null && root2 == null) return true;
		if(root1 != null && root2 == null) return false;
		if(root1 == null && root2 != null) return false;
		
		return (root1.getData() == root2.getData() && (areMirrorTrees(root1.getLeft(), root2.getRight())) && areMirrorTrees(root1.getRight(), root2.getLeft()));
	}
	
	public static void main(String[] args) {
		Node root2 = ConvertBinaryTreeToMirror.convertToMirror(UtilTrees.getBinaryTree1());
		System.out.println(areMirrorTrees(UtilTrees.getBinaryTree1(), root2));

		root2 = ConvertBinaryTreeToMirror.convertToMirror(UtilTrees.getBinaryTree4());
		System.out.println(areMirrorTrees(UtilTrees.getBinaryTree4(), root2));

	}
}
