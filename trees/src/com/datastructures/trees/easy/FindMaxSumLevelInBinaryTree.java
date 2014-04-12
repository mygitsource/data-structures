package com.datastructures.trees.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;

public class FindMaxSumLevelInBinaryTree {

	static int findMaxSumLevelInBinaryTree(Node root){
		if(root == null) return 0;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		int level = 0 , maxLevel = 0, maxSum = 0, currentSum = 0;
		Node temp = null;
		
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp == null){
				// this not required as we want level when the sum is max.. 
//				if(level > maxLevel){
//					System.out.println(level+ "  "+maxLevel);
//					maxLevel =  level;
//				}
				if(currentSum > maxSum){
					maxSum = currentSum;
					maxLevel =  level;
				}
				level++;
				currentSum = 0;
				if(!queue.isEmpty())
					queue.add(null);
			}else{
				currentSum = currentSum + temp.getData();
				if(temp.getLeft() != null) {
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.add(temp.getRight());
				}
			}
		}
		System.out.println(maxLevel+" "+ maxSum);
		return maxLevel;
	}
	
	public static void main(String[] args) {
		System.out.println(findMaxSumLevelInBinaryTree(UtilTrees.getBinaryTree5()));
	}
}
