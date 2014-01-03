package com.datastructures.trees.bt;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;
import com.sun.media.sound.MidiUtils.TempoCache;


public class HeightOfBinaryTree {

/*	There are two conventions to define height of Binary Tree
	1) Number of nodes on longest path from root to the deepest node.
	2) Number of edges on longest path from root to the deepest node.
*/
	
	private static int heightOfTreeIterative(Node root){
		if(root == null) return 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		Node temp = null;
		int level = 0;
		
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp == null){
				level++;
				if(!queue.isEmpty())
					queue.add(null);
			}else{ 
				if(temp.getLeft() != null){
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.add(temp.getRight());
				}
			}
		}
		return level;
	}
	
	
	public static void main(String[] args) {
		System.out.println(heightOfTreeIterative(UtilTrees.getBinaryTree1()));
		System.out.println(Util.height(UtilTrees.getBinaryTree1()));
		System.out.println(height(UtilTrees.getBinaryTree1()));
	}
	
	/*
	 * 
	 1. If tree is empty then return 0
	 2. Else
     (a) Get the max depth of left subtree recursively  i.e., 
          call maxDepth( tree->left-subtree)
     (a) Get the max depth of right subtree recursively  i.e., 
          call maxDepth( tree->right-subtree)
     (c) Get the max of max depths of left and right 
          subtrees and add 1 to it for the current node.
         max_depth = max(max dept of left subtree, max depth of right subtree) + 1
     (d) Return max_depth
	 */
	
	private static int height(Node node){
		if(node == null){
			return 0;
		}
		int left = height(node.getLeft());
		int right = height(node.getRight());
		
		if(left > right){
			return (left+1);
		}else
			return (right+1);
		
	}
	
}
