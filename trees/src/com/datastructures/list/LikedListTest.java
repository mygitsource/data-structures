package com.datastructures.list;

public class LikedListTest {

	public static void main(String[] args) {
		LinkedList list = getLinkedList1();
		ListNode temp = list.getHead();
		while(temp != null){
			System.out.println(temp);
			temp = temp.getNext();
		}
		
	}
	
	
	public static LinkedList getLinkedList1(){
		LinkedList likedList  = new LinkedList();
		for (int i = 0; i < 10; i++) {
			//ListNode x = new ListNode(i);
			likedList.insertNode(i);
		}
		return likedList;
	}
}
