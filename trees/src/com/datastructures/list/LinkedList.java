package com.datastructures.list;

public class LinkedList {
	
	private ListNode head = null;
	private ListNode tail = null;
	
	//TODO make this as insert at head
	//this is insert at end
	public void insertNode(int data){
		ListNode node = new ListNode(data, null);
		if(head == null && tail == null){
			head = node;
			tail = node;
		}else{
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
	}
	
	public ListNode getHead(){
		return (head == null? null:head);
	}
	
	public ListNode getTail(){
		return (tail == null? null:tail);
	}

	public void setHead(ListNode head){
		this.head = head;
	}

}
