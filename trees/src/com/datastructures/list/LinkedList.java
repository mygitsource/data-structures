package com.datastructures.list;

import com.datastructures.trees.util.Util;

public class LinkedList {
	
	private ListNode head = null;
<<<<<<< HEAD
	private ListNode tail = null;
	
	//TODO make this as insert at head
	//this is insert at end
	public void insertNode(int data){
		ListNode node = new ListNode(data, null);
		if(head == null && tail == null){
=======
	
	//insert at begining
	public void insertNode(ListNode head, int data){
		ListNode node = new ListNode(data, head);
		this.head = node;
	}
	
	public void insertAt(int data, ListNode node){
		if(node == null){
			ListNode nNode = new ListNode(data, null);
>>>>>>> 51908d69876229a973d30d7327c81de686eca44d
			head = node;
		}else {
			ListNode next = node.getNext();
			ListNode nNode = new ListNode(data, next);
			node.setNext(nNode);
		}
	}
	
	public void addNext(int data){
		if(head == null){
		 insertNode(data);
		}else{
<<<<<<< HEAD
			if(tail !=null)
				tail.setNext(node);
			tail = node;
		}
	}
	
	public void insertAtBegin(int data){
		ListNode node = new ListNode(data, null);
		if(head == null){
			head = node;
		}else{
			ListNode tmp = head;
			head = node;
			node.setNext(tmp);
		}
=======
		ListNode tail = getTail();
		ListNode node = new ListNode(data, null);
		tail.setNext(node);
		}
	}
	
	public void insertNode(int data){
		ListNode node = new ListNode(data, head);
		this.head = node;
	}

	public ListNode getTail(){
		ListNode currNode = head;
		while(currNode.getNext() != null){
			currNode = currNode.getNext();
		}
		return currNode;
>>>>>>> 51908d69876229a973d30d7327c81de686eca44d
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
