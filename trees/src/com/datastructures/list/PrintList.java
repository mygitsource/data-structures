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
		linkedList.insertNode(linkedList.getHead(),1);
		linkedList.insertNode(linkedList.getHead(),2);
		linkedList.insertNode(linkedList.getHead(),3);
		linkedList.insertNode(linkedList.getHead(),4);
		linkedList.insertNode(linkedList.getHead(),5);
		linkedList.insertNode(linkedList.getHead(),6);
		printRecursively(linkedList.getHead());
		System.out.println("**************");
		printReverseRecursively(linkedList.getHead());
	}
}
