package com.datastructures.list;


public class FlattenALinkedListWithNextAndChildPointers {

	static Node flatttenLinkedList(Node head){
		if(head == null) return null;
		Node tmp;
		Node tail = head;
		Node current = head;
		
		//go to the tail of the first level list
		while(tail.next != null){
			tail = tail.next;
		}
		
		//One by one traverse through all nodes of first level 
	    // linked list till we reach the tail node
		while(current != tail){
			if(current.child != null){
				tail.next = current.child;
				
				tmp = current.child;
				while(tmp.next != null){
					tmp = tmp.next;
				}
				tail = tmp;
			}
			current = current.next;
		}
		return head;
	}

	static class Node{
		int data;
		Node next;
		Node child;
		
		Node(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return Integer.toString(data);
		}
	}
	
	static class LinkedList{
		Node head = null;
		Node tail = null;

		public void insertNode(int data){
			Node node = new Node(data);
			if(head == null && tail == null){
				head = node;
				tail = node;
			}else{
				tail.next = node;
				tail = node;
			}
		}
	}
	
	static LinkedList createList(int[] array){
		LinkedList linkedList = new LinkedList();
		for (int i = 0; i < array.length; i++) {
			linkedList.insertNode(array[i]);
		}
		return linkedList;
	}
	
	public static void main(String[] args) {
		int arr1[] = {10, 5, 12, 7, 11};
	    int arr2[] = {4, 20, 13};
	    int arr3[] = {17, 6};
	    int arr4[] = {9, 8};
	    int arr5[] = {19, 15};
	    int arr6[] = {2};
	    int arr7[] = {16};
	    int arr8[] = {3};
		LinkedList linkedList1  = createList(arr1);
		LinkedList linkedList2  = createList(arr2);
		LinkedList linkedList3  = createList(arr3);
		LinkedList linkedList4  = createList(arr4);
		LinkedList linkedList5  = createList(arr5);
		LinkedList linkedList6 = createList(arr6);
		LinkedList linkedList7  = createList(arr7);
		LinkedList linkedList8  = createList(arr8);

		
		linkedList1.head.child = linkedList2.head;
		linkedList1.head.next.next.next.child = linkedList3.head;
		linkedList3.head.child = linkedList4.head;
		linkedList4.head.child = linkedList5.head;
		linkedList2.head.next.child = linkedList6.head;
		linkedList2.head.next.next.child = linkedList7.head;
		linkedList7.head.child = linkedList8.head;		
	
		Node head = flatttenLinkedList(linkedList1.head);
		while(head != null){
			System.out.print(head);
			head = head.next;
			if(head != null)
				System.out.print("->");
		}
		System.out.println();
	}
	
}

