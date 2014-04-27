package com.datastructures.list.easy;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;
import com.datastructures.trees.util.Util;

public class InsertNodeInSortedList {

	static ListNode insertNodeInSortedList(ListNode head, ListNode nNode){
		if(head == null) return null;
		ListNode temp = head;
		ListNode current = null;
		
		while(temp != null && temp.getData() < nNode.getData() ){
			current = temp;
			temp = temp.getNext();
		}
		
		current.setNext(nNode);
		nNode.setNext(temp);
		return head;
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
		ListNode head = insertNodeInSortedList(list.getHead(), new ListNode(45));
		Util.printList(list);
	}
	
}
