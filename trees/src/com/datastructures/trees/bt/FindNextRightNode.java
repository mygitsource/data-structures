package com.datastructures.trees.bt;

import java.util.Queue;

import com.datastructures.list.LinkedList;
import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

/**
 * Find a node right to the given key in a binary tree.
 * http://www.geeksforgeeks.org/find-next-right-node-of-a-given-key/
 */

public class FindNextRightNode {

	//TODO: BFS or DFS
	
	public static void main(String[] args) {
		Node node = UtilTrees.getBinaryTree1();
		Node val = findNextRightNode_LevelOrder(node, 5);
		System.out.println(val);
	}
	
	/**
	 * using level order traversal.
	 * @param node
	 * @return
	 */
	private static Node findNextRightNode_LevelOrder(Node node, int key){
		if(node == null) return null;
		Queue<Node> queue = new java.util.LinkedList<>();
		queue.add(node);
		queue.add(null);
		Node rightNode = null;
		int level = 1;
		int foundLevel = 0;
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			if(temp == null){
				level++;
				if(!queue.isEmpty())
					queue.add(null);
			}else{
				if(foundLevel == level){
					rightNode = temp;
					break;
				}
				if(temp.getData() == key){
					foundLevel = level;
				}
				if(temp.getLeft() != null){
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.add(temp.getRight());
				}
			}
		}
		return rightNode;
	}
	
}
