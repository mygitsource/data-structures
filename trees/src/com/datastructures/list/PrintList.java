package com.datastructures.list;

public class PrintList {

	private static void printRecursively(ListNode node){
		if(node == null) return;
		System.out.print(node+" ");
		printRecursively(node.getNext());
	}

	private static void printReverseRecursively(ListNode node){
		if(node == null) return;
		printReverseRecursively(node.getNext());
		System.out.print(node+" ");
	}

	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insertAtEnd(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);
		printRecursively(linkedList.getHead());
		System.out.println("\n**************");
		printReverseRecursively(linkedList.getHead());
	}
}
