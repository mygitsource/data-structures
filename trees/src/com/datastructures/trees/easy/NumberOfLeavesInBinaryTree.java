package com.datastructures.trees.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class NumberOfLeavesInBinaryTree {

	
	static int numberOfLeavesInBinaryTree(Node root){
		if(root == null) return -1;
		Node temp = null;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp != null){
				if(temp.getLeft() != null){
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.add(temp.getRight());
				}
				//set of node whose both left and right are null are called lefe nodes.
				if(temp.getLeft() == null && temp.getRight() == null){
					count++;
				}
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		System.out.println(numberOfLeavesInBinaryTree(UtilTrees.getBinaryTree3()));
	}
}
