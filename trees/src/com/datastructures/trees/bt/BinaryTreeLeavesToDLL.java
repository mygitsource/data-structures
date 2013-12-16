package com.datastructures.trees.bt;

import com.datastructures.list.LinkedList;
import com.datastructures.trees.Node;
import com.datastructures.trees.util.StaticTrees;
import com.datastructures.trees.util.Util;

public class BinaryTreeLeavesToDLL {
	
	public static LinkedList extractLeaves(Node node, Node parent,LinkedList list){
		if(node == null || list == null) return null;
		
		if(node.getLeft() == null && node.getRight() == null){
			list.insertNode(node.getData());
			
			if(parent.getLeft() != null && parent.getLeft().getData() == node.getData()){
				parent.setLeft(null);
			}else if(parent.getRight() != null && parent.getRight().getData() == node.getData()){
				parent.setRight(null);
			}
		}
		extractLeaves(node.getLeft(), node, list);
		extractLeaves(node.getRight(), node, list);
		return list;
	}

	
	public static void main(String args[])	{
		Node node = StaticTrees.getBinaryTree2();
		Util.printInorderTraversal(node);
		System.out.println("********************");
		LinkedList list = new LinkedList();
		list = extractLeaves(node, node, list);
		Util.printList(list);
		System.out.println("********************");
		Util.printInorderTraversal(node);
	}
	
}
