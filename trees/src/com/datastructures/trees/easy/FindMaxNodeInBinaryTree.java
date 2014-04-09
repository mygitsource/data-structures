package com.datastructures.trees.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class FindMaxNodeInBinaryTree {

	static class MaxVal{
		int max;
		void setMax(int max){
			this.max = max;
		}
	}
	//using reference thro recursion instead primitive 
	static MaxVal findMaxNode(Node root, MaxVal max) {
		int value, left, right;

		if(root != null){
			value = root.getData();
			left = findMaxNode(root.getLeft(), max).max;
			right = findMaxNode(root.getRight(), max).max;
			
			if(left > max.max){
				max.setMax(left);
			}else if(right > max.max){
				max.setMax(right);
			}
			if(value > max.max)
				max.setMax(value);
		}
		return max;
	}
	
	static void testFindMaxNode1() {
		MaxVal max = new MaxVal();
		max.setMax(Integer.MIN_VALUE);
		max = findMaxNode(UtilTrees.getBinaryTree5(), max);
		System.err.println(max.max);
	}
	
	//WithOut recursion
	static int findMaxNode(Node root){
		if(root == null) return Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		Queue queue = new LinkedList<>();
		queue.add(root);
		Node temp = null;
		while(!queue.isEmpty()){
			temp = (Node)queue.poll();
			if(temp != null){
				if(temp.getLeft() != null)
					queue.add(temp.getLeft());
				if(temp.getRight() != null)
					queue.add(temp.getRight());

				if(temp.getData() > max){
					max = temp.getData();
				}
			}
		}
		return max;
	}
	
	static void testFindMaxNode2(){
		int max = findMaxNode(UtilTrees.getBinaryTree4());
		System.out.println(max);
	}

	public static void main(String[] args) {
		testFindMaxNode2();
	}
	
}
