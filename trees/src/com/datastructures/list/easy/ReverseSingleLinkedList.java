package com.datastructures.list.easy;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;
import com.datastructures.trees.util.Util;

public class ReverseSingleLinkedList {

	/*
	 *  increment head and move prev to head and have next as next head.
	 */
	static ListNode reverseLinkedList(ListNode head){
		ListNode next = null;
		ListNode prev = null;
		while(head != null){
			next = head.getNext();
			head.setNext(prev);
			prev = head;
			head =next;
		}
		return prev;
	}
	
	/*
	 *  take a statoc head as globla
	 *  when list is at end/tail, that is our new head.
	 * 
	 */
	static ListNode nHead;
	static void reverseLinkedList_Recursion(ListNode head){
		if(head == null) return;
		//new head at the end of the list/tail
		if(head.getNext() == null){
			nHead = head; return; 
		}
		reverseLinkedList_Recursion(head.getNext());
		//80.next(90).next = 80
		head.getNext().setNext(head);
		head.setNext(null);
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtEnd(10);
		list.insertAtEnd(20);
		list.insertAtEnd(30);
		list.insertAtEnd(40);
		list.insertAtEnd(50);
		list.insertAtEnd(60);
		list.insertAtEnd(70);
		list.insertAtEnd(80);
		list.insertAtEnd(90);
		Util.printList(list);
//		ListNode head = reverseLinkedList(list.getHead());
		reverseLinkedList_Recursion(list.getHead());

		Util.printListNode(nHead);
	}

}
