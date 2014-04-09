package com.datastructures.trees.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class FindSizeOfBinaryTree {

	static int size(Node root){
		if(root == null) return 0;

		int left = size(root.getLeft());
		int right = size(root.getRight());
		return (left+1+right);
		//return (size(root.getLeft()) + 1 + size(root.getRight()));
	}
	
	public static void main(String[] args) {
		System.out.println(size(UtilTrees.getBinaryTree1()));
		System.out.println(sizeWithoutRecursion(UtilTrees.getBinaryTree1()));
	}
	
	
	
	static int sizeWithoutRecursion(Node root){
		if(root == null) return 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node temp = null;
		int size = 0;
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp != null){
				size++;
				if(temp.getLeft() != null)
					queue.add(temp.getLeft());
				if(temp.getRight() != null)
					queue.add(temp.getRight());
			}
		}
		return size;
	}
}
