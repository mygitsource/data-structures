package com.datastructures.list.easy;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;
import com.datastructures.trees.util.Util;

public class ReverseListInPairs {

	static ListNode reverseListInPairs(ListNode head){
		if(head == null) return null;
		ListNode current = head.getNext();
		ListNode prev = head;
		head = current;
		
		while(true){
			ListNode next = current.getNext();
			current.setNext(prev);
			if(next == null || next.getNext() == null){
				prev.setNext(next);
				break;
			}
			prev.setNext(next.getNext());
			current = next.getNext();
			prev = next;
		}
		
		return head;
	}

	
	static ListNode reverseListInPairs_Recursion(ListNode head){
		if(head == null || head.getNext() == null) return head;
		
		ListNode current = head.getNext().getNext();
		ListNode header = head.getNext();
		head.getNext().setNext(head);
		head.setNext(reverseListInPairs_Recursion(current));
		return header;
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
//		ListNode head = reverseListInPairs(list.getHead());
		ListNode head = reverseListInPairs_Recursion(list.getHead());
		Util.printListNode(head);;
	}		
}
