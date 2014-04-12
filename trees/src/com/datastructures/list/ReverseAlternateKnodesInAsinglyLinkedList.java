package com.datastructures.list;

import com.datastructures.trees.util.Util;

/*
 Given a linked list, write a function to reverse every alternate k nodes (where k is an input to the function) 
 in an efficient way. Give the complexity of your algorithm.

Example:
Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
Output:   3->2->1->4->5->6->9->8->7->NULL. 

 */
public class ReverseAlternateKnodesInAsinglyLinkedList {

	
	public ListNode reverseAListInAlternateKnodes_2(ListNode head, int k){
		return reverseAListInAlternateKnodes_2(head, k, true);
	}

	public ListNode reverseAListInAlternateKnodes_2(ListNode head, int k, boolean reverse){
		if(head == null) return null;
		ListNode temp = head;
		ListNode prev = null;
		ListNode next = null;
		
		int c = k;
		while(temp != null && (c-- != 0)){
			next = temp.getNext();
			if(reverse)
			temp.setNext(prev);
			prev = temp;
			temp = next; 
		}
		
		if(reverse){
			head.setNext(reverseAListInAlternateKnodes_2(temp, k, !reverse));
			return prev;
		}else {
			prev.setNext(reverseAListInAlternateKnodes_2(temp, k, !reverse));
			return head;
		}
	}

	
	public ListNode reverseAListInAlternateKnodes(ListNode head,  int k){
		ListNode temp = head;
		ListNode next = null;
		ListNode prev = null;
		int c = k;
		while(temp != null && (c-- != 0)){
			next = temp.getNext();
			temp.setNext(prev);
			prev = temp;
			temp = next;
		}
		if(head != null){
			head.setNext(temp);
		}
		c = k;
		while(temp != null && (--c != 0)){
			temp = temp.getNext();
		}
		if(temp != null){
			System.out.println("1: "+temp);
			ListNode test = reverseAListInAlternateKnodes(temp.getNext(), k);
			temp.setNext(test);
		}
		System.out.println("Prev : "+prev);
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
		list.insertNode(90);
		list.insertNode(100);
		list.insertNode(110);
		list.insertNode(120);
		
		Util.printList(list);

		ReverseAlternateKnodesInAsinglyLinkedList aList = new ReverseAlternateKnodesInAsinglyLinkedList();
//		ListNode head = aList.reverseAListInAlternateKnodes(list.getHead(), 2);
		ListNode head = aList.reverseAListInAlternateKnodes_2(list.getHead(), 3);
		Util.printListNode(head);
	}
	
}
