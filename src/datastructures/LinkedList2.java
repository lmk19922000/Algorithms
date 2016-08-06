package datastructures;

public class LinkedList2<T> {
	ListNode<T> head;
	
	public void append(T value){
		ListNode<T> newNode = new ListNode<T>(value);
		
		if(this.head == null){
			this.head = newNode;
		} else {
			ListNode<T> currNode = this.head;
			
			while (currNode.getNext() != null){
				currNode = currNode.getNext();
			}
			
			currNode.setNext(newNode);
		}
	}
	
	public ListNode<T> getHead(){
		return this.head;
	}
	public void printList(){
		ListNode<T> currNode = this.head;
		
		while(currNode != null){
			System.out.println(currNode.getValue());
			currNode = currNode.getNext();
		}
	}
	
	public void reverseList(){
		ListNode<T> oldHead = this.head;
		reverseListRec(this.head);
		
		if(oldHead != null){
			oldHead.setNext(null);
		}
	}
	
	private ListNode<T> reverseListRec(ListNode<T> node){
		if(node == null){
			return null;
		}
		
		if(node.getNext() == null){
			this.head = node;
			return node;
		}
		
			ListNode<T> reversedNode = reverseListRec(node.getNext());
			reversedNode.setNext(node);
			
			return node;
	}
}
