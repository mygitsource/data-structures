package com.datastructures.trees.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class FindElementInBinaryTree {

	static boolean findElement(Node root, int k){
		if(root == null) return false;
		
		if(root.getData() == k){
			return true;
		}
		return (findElement(root.getLeft(), k) || findElement(root.getRight(), k));
	}
	
	public static void main(String[] args) {
		//System.out.println(findElement(UtilTrees.getBinaryTree4(), 76));
		System.out.println(findElementWithRecursion(UtilTrees.getBinaryTree4(), 67));
	}
	
	//Without recursion
	static boolean findElementWithRecursion(Node root, int k){
		if(root == null) return false;
		Node temp = null;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp != null){
				if(temp.getData() == k){
					return true;
				}
				
				if(temp.getLeft() != null){
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.add(temp.getRight());
				}
			}
		}
		return false;
	}
}
