package com.datastructures.list;

import com.datastructures.trees.util.Util;

/*
 Given a linked list, write a function to reverse every k nodes (where k is an input to the function).

Example:
Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
Output:  3->2->1->6->5->4->8->7->NULL. 

Inputs:   1->2->3->4->5->6->7->80->NULL and k = 5
Output:  5->4->3->2->1->8->7->6->NULL. 

 */
public class ReverseAListInGroupsOfGiven {

	public ListNode reverseAListInGroups(ListNode head,  int k){
		ListNode temp = head;
		if(temp.getNext() == null) {
			return temp;
		}
		ListNode next = null;
		ListNode prev = null;
		int c = k;
		while(temp.getNext() != null && (c-- != 0)){
			next = temp.getNext();
			temp.setNext(prev);
			prev = temp;
			temp = next;
		}
		if(next != null){
			ListNode test = reverseAListInGroups(next, k);
			head.setNext(test);
		}
		return prev;
	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertNode(10);
		list.insertNode(20);
		list.insertNode(30);
		list.insertNode(40);
		list.insertNode(50);
		list.insertNode(60);
		list.insertNode(70);
		list.insertNode(80);
		
		Util.printList(list);

		ReverseAListInGroupsOfGiven aList = new ReverseAListInGroupsOfGiven();
		ListNode head = aList.reverseAListInGroups(list.getHead(), 3);
		Util.printListNode(head);
	}
	
}
