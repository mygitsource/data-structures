package com.datastructures.list;

public class ListNode {
	
	public ListNode(int data){
		this.data = data;
	}
	
	private int data = -1;
	private ListNode prev = null;
	private ListNode next = null;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getPrev() {
		return prev;
	}
	public void setPrev(ListNode prev) {
		this.prev = prev;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return Integer.toString(data);
	}
}
