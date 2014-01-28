package com.datastructures.list;

import com.datastructures.trees.util.Util;

public class LinkedList {
	
	private ListNode head = null;
	
	//insert at begining
	public void insertNode(ListNode head, int data){
		ListNode node = new ListNode(data, head);
		this.head = node;
	}

	public void insertNode(int data){
		ListNode node = new ListNode(data, head);
		this.head = node;
	}

	public ListNode getTail(){
		ListNode currNode = head;
		while(currNode != null && currNode.getNext() != null){
			currNode = currNode.getNext();
		}
		return currNode;
	}
	
	public ListNode getHead(){
		return (head == null? null:head);
	}
	
	public void setHead(ListNode head){
		this.head = head;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertNode(list.getHead(), 10);
		list.insertNode(list.getHead(), 20);
		list.insertNode(list.getHead(), 30);
		list.insertNode(list.getHead(), 40);
		list.insertNode(list.getHead(), 50);
		list.insertNode(list.getHead(), 60);
		Util.printList(list);
		
	}
}
