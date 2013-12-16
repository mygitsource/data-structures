package com.datastructures.trees.util;

import java.util.Queue;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;
import com.datastructures.trees.Node;

public class Util {

	public static void printList(LinkedList node){
		ListNode temp = node.getHead();
		while(temp != null){
			System.out.println(temp);
			temp = temp.getNext();
		}
	}
	
	public static void printInorderTraversal(Node node){
		if(node == null) return;
		printInorderTraversal(node.getLeft());
		System.out.println(node.getData());
		printInorderTraversal(node.getRight());
	}
	
	public static  int height(Node node){
		if(node == null) return 0;
		
		int lHeight = height(node.getLeft());
		int rHeight = height(node.getRight());
		
		if(lHeight > rHeight){
			return lHeight+1;
		}else{
			return rHeight+1;
		}
	}
	
	public static  void levelOrderTraversal(Node node){
		if(node == null) return;
		Queue<Node> queue = new java.util.LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			System.out.println(temp.getData());
			if(temp.getLeft() != null){
				queue.add(temp.getLeft());
			}
			if(temp.getRight() != null){
				queue.add(temp.getRight());
			}
		}
	}
	
	public static  void levelOrderTraversalUsingHeight(Node node){
		int height = height(node);
		for(int i =1; i <= height; i++){
			levelOrderTraversal(node, i);
			System.out.print("\n");
		}
	}
	
	/**
	 * print the value of given level.
	 * @param node
	 * @param level
	 */
	
	public static  void levelOrderTraversal(Node node, int level){
		if(node == null) return;
		if(level == 1){
			System.out.print(node);
		}else{
			levelOrderTraversal(node.getLeft(), level-1);
			levelOrderTraversal(node.getRight(), level-1);
		}

	}
	
}
