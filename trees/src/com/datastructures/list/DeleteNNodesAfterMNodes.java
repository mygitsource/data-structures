package com.datastructures.list;

import com.datastructures.trees.util.Util;

/*
 * Input:
M = 2, N = 2
Linked List: 1->2->3->4->5->6->7->8
Output:
Linked List: 1->2->5->6

 */
public class DeleteNNodesAfterMNodes {

	void deleteNNodesAndSkipMNodes(ListNode node, int n, int m){
		if(node == null) return;
		
		ListNode tmpNode = new ListNode(-1, node);
		ListNode head = node;
		ListNode nextNode = null;
		while(true){
			for(int i = 0 ; i< m && tmpNode != null; i++){
				tmpNode = tmpNode.getNext();
			}
			if(tmpNode == null) return;
			nextNode = tmpNode;
			for(int i = 0 ; i<= n && nextNode != null; i++){
				nextNode = nextNode.getNext();
				
			}
			tmpNode.setNext(nextNode);
		}
	}

	
	public static void main(String[] args) {
		DeleteNNodesAfterMNodes nodes = new DeleteNNodesAfterMNodes();
		LinkedList linkedList = new LinkedList();
		for(int i = 16; i > 0 ; i--)
			linkedList.insertNode(i);
		Util.printList(linkedList);
		nodes.deleteNNodesAndSkipMNodes(linkedList.getHead(), 1, 1);
		Util.printList(linkedList);
	}
	
}
