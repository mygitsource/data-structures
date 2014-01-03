package com.datastructures.list;

public class DoubleLinkedList {

	private DLLNode first = null;
	private DLLNode last = null;
	private transient int size = 0;
	
	public void insertFirst(int data){
		DLLNode node = new DLLNode(null,data,first);
		DLLNode temp = first;
		first = node;
		if(temp == null){
			last = node;
		}else {
			temp.setPrev(node);
		}
		size++;
	}
	
	public void insertLast(int data){
		DLLNode node = new DLLNode(last, data, null);
		DLLNode temp = last;
		last = node;
		if(temp == null){
			first = node;
		}else{
			temp.setNext(node);
		}
		size++;
	}
	
	public void insertAt(int data, int index){
		if(index > size){
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		
		if(index == size){
			insertLast(data);
		}else{
			//insert before
			DLLNode node = getNode(index);
			DLLNode temp = node.getPrev();
			DLLNode newNode = new DLLNode(temp, data, node);
			node.setPrev(newNode);
			//if at first location
			if(temp == null){
				first = newNode;
			}else{
				temp.setNext(newNode);
			}
			size++;
		}
	}
	
	private DLLNode getNode(int index){
		DLLNode node = null;
		if(index < (size/2)){
			node = first;
			for(int i = 0 ; i < index; i++){
				node = node.getNext();
			}
			
		}else{
			node = last;
			for(int i = size -1; i > index; i--){
				node = node.getPrev();
			}
		}
		return node;
	}
	
	
	public void insertAfter(int data, DLLNode after){
		DLLNode temp = after.getNext();
		DLLNode node = new DLLNode(after,data, temp);
		after.setNext(node);
		if(temp == null){
			last = node;
		}else{
			temp.setPrev(node);
		}
	}
	
	public void deleteFirst(){
		DLLNode temp = first;
		first = temp.getNext();
		temp.setNext(null);
		first.setPrev(null);
		size--;
	}
	
	public void deleteLast(){
		DLLNode temp = last;
		last = temp.getPrev();
		last.setNext(null);
		temp.setPrev(null);
	}
	
	public void deleteKey(){
		
	}
	
	public void displayForward(){
		DLLNode temp = first;
		while(temp != null){
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
	
	public void displayBackward(){
		DLLNode temp = last;
		while(temp != null){
			System.out.println(temp.getData());
			temp = temp.getPrev();
		}
	}
	
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.insertLast(5);
		list.insertLast(2);
		
		list.insertAt(3, 1);
		list.insertAt(1, 3);

//		list.displayForward();
		//list.displayBackward();
		//System.out.println("*****");
		
		list.insertAfter(4, list.first);
		
//		list.deleteFirst();
		list.deleteLast();
//		list.displayForward();
		list.displayBackward();
		
	}
	
}
