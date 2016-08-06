package datastructures;

public class ListNode<T> {
	private T value;
	private ListNode<T> nextNode;
	
	public ListNode(T val){
		this.value = val;
		this.nextNode = null;
	}
	
	public T getValue(){
		return this.value;
	}
	
	public ListNode<T> getNext(){
		return this.nextNode;
	}

	public void setNext(ListNode<T> node){
		this.nextNode = node;
	}
}
