package com.datastructures.list;

public class MergeTwoSortedLinkedLists_Set1 {

	static ListNode mergeSortedLinkedLists(ListNode head1, ListNode head2){
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		
		LinkedList nList = new LinkedList();		
		ListNode temp = head1;
		ListNode current = head2;
		
		while((temp != null && current != null)){
			if(temp.getData() < current.getData()){
				insertNode(nList, temp.getData());
				temp = temp.getNext();
			}else{
				insertNode(nList, current.getData());
				current = current.getNext();
			}
		}
		
		if(temp != null) {
			insertALL(temp, nList);
		}else if(current != null) {
			insertALL(current, nList);
		}
		return nList.getHead();
	}
	
	static void insertALL(ListNode node, LinkedList nList){
		while(node != null){
			insertNode(nList, node.getData());
			node = node.getNext();
		}
	}
	
	static void insertNode(LinkedList list, int data){
		list.insertNode(data);
	}
	

	public static void main(String[] args) {
		LinkedList list = getLinkedList1(1, 10);
		LinkedList list2 = getLinkedList1(11, 20);
		ListNode temp = mergeSortedLinkedLists(list2.getHead(), list.getHead());
		
		while(temp != null){
			System.out.print(temp);
			temp = temp.getNext();
			if(temp != null){
				System.out.print("->");
			}
		}
		System.out.print("\n");
	}
	
	public static LinkedList getLinkedList1(int s, int e){
		LinkedList likedList  = new LinkedList();
		for (int i = s; i < e; i++) {
			//ListNode x = new ListNode(i);
			likedList.addNext(i);
		}
		return likedList;
	}
}
