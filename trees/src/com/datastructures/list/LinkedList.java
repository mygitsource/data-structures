package com.datastructures.list;

public class LinkedList {
	
	private ListNode head = null;
	private ListNode tail = null;
	
	public void insertNode(ListNode node){
		if(head == null && tail == null){
			head = node;
			tail = node;
		}else{
			tail.setNext(node);
			tail = node;
		}
	}
	
	public void insertNode(int t){
		insertNode(new ListNode(t));
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
