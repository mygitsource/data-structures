package com.datastructures.trees.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class FindAllHalfNodesOfBinaryTree {

	static void findAllHalfNodesRecursion(Node root){
		if(root == null) return ;
		
		if((root.getLeft() == null && root.getRight() != null)||(root.getLeft() != null && root.getRight() == null)){
			System.out.print(root.getData()+" ");
		}
		
		findAllHalfNodesRecursion(root.getLeft());
		findAllHalfNodesRecursion(root.getRight());
		
		return;
	} 
	
	static void findALLHalfNodes(Node root){
		if(root == null) return;
		Node temp = null;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp != null){
				if((temp.getLeft() == null && temp.getRight() != null)||(temp.getRight() == null && temp.getLeft() != null)){
					System.out.print(temp.getData()+" ");
				}
				if(temp.getLeft() != null){
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.add(temp.getRight());
				}
			}
		}
	}
	
	public static void main(String[] args) {
		findAllHalfNodesRecursion(UtilTrees.getBinaryTree4());
		System.out.println();
		findALLHalfNodes(UtilTrees.getBinaryTree4());
	}
}
