package com.datastructures.list;

import com.datastructures.trees.util.Util;

public class ReverseList {

	private static void reverse(LinkedList linkedList){
		if(linkedList == null) return;
		ListNode temp, prev, next;
		prev = null;
		next = null;
		temp = linkedList.getHead();
		
		while(temp != null){
			next = temp.getNext();	//next node
			temp.setNext(prev);		// set previous
			prev = temp;
			temp = next;
		}
		linkedList.setHead(prev);
	}
	private static ListNode head = null;
	private static void reverseUsingRecursion(ListNode node){
		if(node == null)return;
		if(node.getNext() == null){
			head = node;
			return;
		}
		reverseUsingRecursion(node.getNext());
		ListNode temp = node.getNext();
		System.out.println("t: "+temp+" N: "+node);
		if(temp != null)
			temp.setNext(node);
		node.setNext(null);
	}

	/*
	 * 6 next =5
	 * 5 next =4
	 * 4 next = 3
	 * 3 next = 2
	 * 2 next =1
	 * 
	 */
	
	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();
		linkedList.insertNode(1);
		linkedList.insertNode(2);
		linkedList.insertNode(3);
		linkedList.insertNode(4);
		linkedList.insertNode(5);
		linkedList.insertNode(6);
//		Util.printList(linkedList);
//		reverse(linkedList);
//		System.out.println("*********************");
//		Util.printList(linkedList);
		reverseUsingRecursion(linkedList.getHead());
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.getNext();
		}
	}
}
