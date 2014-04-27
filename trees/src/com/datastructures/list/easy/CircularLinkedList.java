package com.datastructures.list.easy;

import com.datastructures.list.ListNode;

public class CircularLinkedList {

	ListNode head = null;
	
	void insertAtEnd(int data){
		ListNode nNode = new ListNode(data);
		if(head == null){
			head = nNode;
			head.setNext(head);
		}else{
			ListNode temp = head;
			while(temp.getNext() != head){
				temp = temp.getNext();
			}
			temp.setNext(nNode);
			nNode.setNext(head);
		}
	}
	
	// need to reset head to new node
	void insertAtFront(int data){
		ListNode nNode = new ListNode(data);
		if(head == null){
			head = nNode;
			head.setNext(head);
		}else{
			ListNode temp = head;
			while(temp.getNext() != head){
				temp = temp.getNext();
			}
			nNode.setNext(head);
			temp.setNext(nNode);
			head = nNode;
		}
	}
	
	void deleteLast(){
		ListNode temp = head;
		ListNode current = head;
		while(temp.getNext() != head){
			current = temp;
			temp = temp.getNext();
		}
		current.setNext(head);
		temp = null;
	}

	void deleteFirst(){
		ListNode temp = head;
		while(temp.getNext() != head){
			temp = temp.getNext();
		}
		temp.setNext(head.getNext());
		head = head.getNext();
	}

	public ListNode getHead(){
		return head;
	}
	
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		list.insertAtEnd(10);
		list.insertAtEnd(20);
		list.insertAtEnd(30);
		list.insertAtEnd(40);
		list.insertAtEnd(50);
		
		list.insertAtFront(9);
		list.insertAtFront(8);
		list.insertAtFront(7);
		list.insertAtFront(6);
		list.deleteLast();
		list.deleteFirst();
		ListNode head = list.getHead();
		ListNode temp = list.getHead();
		
		while(temp.getNext() != head){
			System.out.print(temp+"->");
			temp =temp.getNext();
		}
	}
}
