package com.datastructures.list;

import com.datastructures.trees.util.Util;

public class LinkedList {
	
	private ListNode head = null;	
	private int size = 0;
	
	public void insertFirst(int data){
		ListNode node = new ListNode(data);
		node.setNext(head);
		head = node;
		size++;
	}
	
	public void insertAt(int data, ListNode node){
		if(node == null){
			ListNode nNode = new ListNode(data);
			head = node;
		}else {
			ListNode next = node.getNext();
			ListNode nNode = new ListNode(data);
			node.setNext(nNode);
			nNode.setNext(next);
		}
		size++;
	}
	
	public void insertAtEnd(int data){
		if(head == null){
			insertAtBegin(data);
		}else{
			ListNode node = head;
			while(node.getNext() != null){
				node = node.getNext();
			}
			ListNode nNode = new ListNode(data);
			node.setNext(nNode);
			size++;
		}
	}
	
		
	public void insertAt(int data, int position){
		if(position > size || position < 1){
			throw new RuntimeException("In valid position exception");
		}
		
		ListNode nNode = new ListNode(data);
		if(position == 1){
//			ListNode temp = head;
			nNode.setNext(head);
			head = nNode;
		}else{
			ListNode temp = head;
			int count = position;
			while(count > 1){
				temp = temp.getNext(); count--;
			}
			ListNode cNode = temp.getNext();
			temp.setNext(nNode);
			nNode.setNext(cNode);
		}
		
		size++;
	}
		
	
	public void deleteFirst(){
		ListNode temp = head.getNext();
		head = temp;
		size--;
	}
	
	public void deleteEnd(){
		ListNode temp = head;
		while(temp.getNext().getNext() != null){
			temp = temp.getNext();
		}
		temp.setNext(null);
		size--;
	}
	
	public ListNode deleteNode(int position){
		if(position > size || position <1){
			throw new RuntimeException("InValid postion.");
		}
		if(position == 1){
			ListNode xhead = head;
			ListNode temp = head.getNext();
			head = temp;
			xhead = null;
		}else{
			int count = position;
			ListNode temp = head;
			while(count > 1){
				count--;
				temp = temp.getNext();
			}
			ListNode next = temp.getNext();
			temp.setNext(next.getNext());
			next = null;
		}
		size--;
		return head;
	}
	
	
	@Deprecated
	public void insertNode(ListNode head, int data){
		ListNode node = new ListNode(data, head);
		this.head = node;
		size++;
	}
	

	@Deprecated
	public void addNext(int data){
		if(head == null){
		 insertNode(data);
		}else{
		ListNode tail = getTail();
		ListNode node = new ListNode(data, null);
		tail.setNext(node);
		size++;
		}
	}
	
	public void insertAtBegin(int data) {
		insertFirst(data);
	}	
	
	@Deprecated
	public void insertNode(int data){
		ListNode node = new ListNode(data, head);
		this.head = node;
		size++;
	}

	public ListNode getTail(){
		ListNode currNode = head;
		while(currNode.getNext() != null){
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
	
	public int pop(){
		int temp = head.getData();
		head = head.getNext();
		size--;
		return temp;
	}
	
	public int size(){
		return size;
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
		list.insertAtBegin(9);
		Util.printList(list);
		list.insertAt(35, 4);
		Util.printList(list);
		list.insertAt(95, 11);
		list.insertAtEnd(110);
		Util.printList(list);
		list.deleteEnd();
		list.deleteNode(11);
		Util.printList(list);
		list.deleteNode(4);
		list.deleteFirst();
		Util.printList(list);
		System.out.println(list.size());
		
	}
}
