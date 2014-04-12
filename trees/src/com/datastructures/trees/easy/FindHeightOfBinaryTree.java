package com.datastructures.trees.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;

public class FindHeightOfBinaryTree {

	static int findHeight(Node root){
		if(root == null) return 0;
		
/*		int left = findHeight(root.getLeft());
		int right = findHeight(root.getRight());
		return (Math.max(left, right))+1;
*/		return (Math.max(findHeight(root.getLeft()), findHeight(root.getRight())))+1;

	}

	public static void main(String[] args) {
		System.out.println(Util.height(UtilTrees.getBinaryTree1()));
		System.out.println(findHeight(UtilTrees.getBinaryTree1()));
		
		System.out.println(findHeightWithOutRecursion(UtilTrees.getBinaryTree1()));
	}
	
	static int findHeightWithOutRecursion(Node root){
		if(root == null) return 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		Node temp = null;
		int height = 0;
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp == null){
				height++;
				if(!queue.isEmpty())
					queue.add(null);
			}else {
				if(temp.getLeft() != null)
					queue.add(temp.getLeft());
				if(temp.getRight() != null)
					queue.add(temp.getRight());
			}
		}
		return height;		
	}
	
}
