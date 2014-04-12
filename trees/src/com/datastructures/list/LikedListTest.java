package com.datastructures.list;

public class LikedListTest {

	public static void main(String[] args) {
		LinkedList list = getLinkedList1();
		ListNode temp = list.getHead();
		while(temp != null){
			System.out.print(temp);
			temp = temp.getNext();
			if(temp != null){
				System.out.print("->");
			}
		}
		System.out.print("\n");
	}
	
	
	public static LinkedList getLinkedList1(){
		LinkedList likedList  = new LinkedList();
		for (int i = 0; i < 10; i++) {
			//ListNode x = new ListNode(i);
			likedList.insertNode(likedList.getHead(),i);
		}
		return likedList;
	}
}
