package com.datastructures.list;

public class PrintList {

	private static void printRecursively(ListNode node){
		if(node == null) return;
		System.out.println(node);
		printRecursively(node.getNext());
	}

	private static void printReverseRecursively(ListNode node){
		if(node == null) return;
		printReverseRecursively(node.getNext());
		System.out.println(node);
	}

	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.insertNode(1);
		linkedList.insertNode(2);
		linkedList.insertNode(3);
		linkedList.insertNode(4);
		linkedList.insertNode(5);
		linkedList.insertNode(6);
		printRecursively(linkedList.getHead());
		System.out.println("**************");
		printReverseRecursively(linkedList.getHead());
	}
}
