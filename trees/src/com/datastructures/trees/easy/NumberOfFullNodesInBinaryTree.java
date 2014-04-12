package com.datastructures.trees.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class NumberOfFullNodesInBinaryTree {

	static int numberOfFullNodes(Node root){
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
				
				//set of node whose both left and right are not null are full nodes
				if(temp.getLeft() != null && temp.getRight() != null){
					count++;
				}
			}
		}
		return count;
	}
	
	//Using recursion 
	static Node numberOfFullNodes(Node root, Counter count){
		if(root == null) return null;
		Node left = null, right = null;
		left = numberOfFullNodes(root.getLeft(), count);
		right = numberOfFullNodes(root.getRight(), count);
		
		if(left != null && right != null){
			count.incCount();
		}
		return root ;
	}
	static class Counter{
		int count;
		void incCount(){
			count++;
		}
		@Override
		public String toString() {
			return Integer.toString(count);
		}
	}
	public static void main(String[] args) {
		System.out.println(numberOfFullNodes(UtilTrees.getBinaryTree3()));
		Counter counter = new Counter();
		numberOfFullNodes(UtilTrees.getBinaryTree3(), counter);
		System.out.println(counter);
	}
}
