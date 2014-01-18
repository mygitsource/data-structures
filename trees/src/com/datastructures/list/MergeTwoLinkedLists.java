package com.datastructures.list;

import com.datastructures.trees.util.Util;

/*
 * 
===========Merge a linked list into another linked list at alternate positions============

insert nodes of second list into first list at alternate positions of first list.

	first  : 5->7->17->13->11 
	second : 12->10->2->4->6
	first list should become : 5->12->7->10->17->2->13->4->11->6
	 
	The nodes of second list should only be inserted when there are positions available. 
	first : 1->2->3 
	second : 4->5->6->7->8,
	
	first will be : 1->4->2->5->3->6 
	second : 7->8.

 */
public class MergeTwoLinkedLists {

	void mergeTwoLinkedLists(LinkedList list1, LinkedList list2){
		ListNode head1 = list1.getHead();
		ListNode head2 = list2.getHead();
		
		ListNode current = head1;
		
		while(current != null){
			//before going to start linking , get the next current and next newhead nodes
			ListNode nextCurr = current.getNext();   // get next current in list1
			ListNode newHead = head2.getNext();	// get the list2 head
			
			//set current node next to head of the list2 and 
			current.setNext(head2);
			//set head2
			head2.setNext(nextCurr);
			//move currentNode to nextCurrent node and head(list2) to new head.
			current = nextCurr;
			head2 = newHead;	
			
			list2.setHead(head2);
		}
		
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.insertNode(1);
		list1.insertNode(3);
		list1.insertNode(5);
		list1.insertNode(7);
		LinkedList list2 = new LinkedList();
		list2.insertNode(2);
		list2.insertNode(4);
		list2.insertNode(6);
		list2.insertNode(8);
		list2.insertNode(10);
		list2.insertNode(12);
		Util.printList(list1);
		Util.printList(list2);
		MergeTwoLinkedLists lists = new MergeTwoLinkedLists();
		lists.mergeTwoLinkedLists(list1, list2);
		Util.printList(list1);
		Util.printList(list2);
	}
}
