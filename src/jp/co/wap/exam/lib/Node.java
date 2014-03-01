package jp.co.wap.exam.lib;

public class Node<E> {
	private E value;
	private Node<E> nextNode;
	private Node<E> prevNode;

	public Node(E val, Node<E> next, Node<E> prev) {
		this.value = val;
		this.nextNode = next;
		this.prevNode = prev;
	}

	public Node(E val) {
		this.value = val;
		this.nextNode = null;
		this.prevNode = null;
	}

	public E getValue() {
		return this.value;
	}

	public Node<E> getNext() {
		return this.nextNode;
	}

	public Node<E> getPrev() {
		return this.prevNode;
	}

	public void setValue(E val) {
		this.value = val;
	}

	public void setNext(Node<E> next) {
		this.nextNode = next;
	}

	public void setPrev(Node<E> prev) {
		this.prevNode = prev;
	}
}
