package com.datastructures.trees.easy;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class PrintAllPathsFromRootToLeaf {

	static void printPathsFromRootToLeaf(Node root){
		int path[] = new int[256];
		int pathIndex = 0;
		printPathsFromRootToLeaf(root, path, pathIndex);
	}
	
	//preorder traversal and get the data and keep it in array , then print when the node is leaf
	static void printPathsFromRootToLeaf(Node root, int[] path, int pathIndex){
		if(root == null) return;
		
		path[pathIndex] = root.getData();
		pathIndex++;
		
		if(root.getLeft() == null && root.getRight() == null){
			printAry(path, pathIndex);
		}else{
			printPathsFromRootToLeaf(root.getLeft(), path,pathIndex);
			printPathsFromRootToLeaf(root.getRight(), path,pathIndex);
		}
	}
	
	static void printAry(int path[], int length){
		for (int i =0; i < length; i++) {
			System.out.print(path[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		printPathsFromRootToLeaf(UtilTrees.getBinaryTree4());
	}
	
}
