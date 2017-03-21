package dataStructures;

public class LinkedList<T> {
	private ListNode<T> head;
	
	public LinkedList(){
		this.head = null;
	}
	
	public void add(T value){
		ListNode<T> node = new ListNode<T>(value);
		
		// List is empty
		if (head == null){
			head = node;
		} else{
			ListNode<T> currNode = head;
			while(currNode.getNext() != null){
				currNode = currNode.getNext();
			}
			currNode.setNext(node);
		}
	}
	
	public void remove (T val){
		// List is empty, nothing to remove
		if (head == null){
			return;
		} else {
			ListNode<T> currNode = head;
			ListNode<T> prevNode = head;
			do{
				if (currNode.getValue().equals(val)){ // found the node to remove
					if (currNode == head){
						head = currNode.getNext();
						return;
					} else{
						prevNode.setNext(currNode.getNext());
						return;
					}
				}
				prevNode = currNode;
				currNode = currNode.getNext();
			} while(currNode != null);
		}
	}
	
	public boolean contain(T val){
		if (head == null){
			return false;
		} else{
			ListNode<T> currNode = head;
			while(currNode != null){
				if (currNode.getValue() == val){
					return true;
				}
				currNode = currNode.getNext();
			}
		}
		
		return false;
	}
	
	public boolean isEmpty(){
		if (head == null){
			return true;
		}
		
		return false;
	}
	
	public int getSize(){
		int count = 0;
		ListNode<T> currNode = head;
		while (currNode != null){
			count++;
			currNode = currNode.getNext();
		}
		
		return count;
	}
	
	public void print(){
		ListNode<T> currNode = head;
		while (currNode != null){
			System.out.print(currNode.getValue()+ " ");
			currNode = currNode.getNext();
		}
	}
}
