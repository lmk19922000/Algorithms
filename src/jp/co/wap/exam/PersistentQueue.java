package jp.co.wap.exam;

import java.util.NoSuchElementException;

import jp.co.wap.exam.lib.HeadTailNode;
import jp.co.wap.exam.lib.Node;

/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of
 * objects.
 * 
 * @param <E>
 */
public class PersistentQueue<E> {
	// The queue contains only the head and tail nodes, which point to the 2
	// ends of the queue
	private HeadTailNode<E> head;
	private HeadTailNode<E> tail;
	private int size;

	/**
	 * requires default constructor.
	 */
	public PersistentQueue() {
		this.head = new HeadTailNode<E>();
		this.tail = new HeadTailNode<E>();
		this.size = 0;
	}
	
	public PersistentQueue(HeadTailNode<E> inputHead, HeadTailNode<E> inputTail, int size){
		this.head = inputHead;
		this.tail = inputTail;
		this.size = size;
	}
	
	/**
	 * Returns the queue that adds an item into the tail of this queue without
	 * modifying this queue.
	 * 
	 * <pre>
	 * e.g.
	 *   When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue,
	 * this method returns a new queue (2, 1, 2, 2, 6, 4)
	 * and this object still represents the queue (2, 1, 2, 2, 6) .
	 * </pre>
	 * 
	 * If the element e is null, throws IllegalArgumentException.
	 * 
	 * @param e
	 * @return
	 * @throws IllegalArgumentException
	 */
	public PersistentQueue<E> enqueue(E e) {
		if (e == null) {
			throw new IllegalArgumentException();
		}
		
		Node<E> newNode = new Node<E>(e);
		
		// Check if the queue is empty
		if (this.head.getPointingNode() == null && this.tail.getPointingNode() == null){
			return new PersistentQueue<E>(new HeadTailNode<E>(newNode), new HeadTailNode<E>(newNode), this.size+1);
		}
		
		Node<E> lastNode = this.tail.getPointingNode();
		lastNode.setNext(newNode);
		newNode.setPrev(lastNode);
		
		return new PersistentQueue<E>(new HeadTailNode<E>(this.head.getPointingNode()), new HeadTailNode<E>(newNode), this.size+1);	
	}

	/**
	 * Returns the queue that removes the object at the head of this queue
	 * without modifying this queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7, 1, 3, 3, 5, 1) ,
	 * this method returns a new queue (1, 3, 3, 5, 1)
	 * and this object still represents the queue (7, 1, 3, 3, 5, 1) .
	 * </pre>
	 * 
	 * If this queue is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
	public PersistentQueue<E> dequeue() {
		if (this.head.getPointingNode() == null && this.tail.getPointingNode() ==null){
			throw new NoSuchElementException();
		}
		
		// Check if the queue contains only 1 element
		if (this.head.getPointingNode() == this.tail.getPointingNode()){
			return new PersistentQueue<E>(new HeadTailNode<E>(), new HeadTailNode<E>(), 0);
		}
		
		Node<E> firstNode = this.head.getPointingNode();
		return new PersistentQueue<E>(new HeadTailNode<E>(firstNode.getNext()), new HeadTailNode<E>(this.tail.getPointingNode()), this.size-1 );
	}

	/**
	 * Looks at the object which is the head of this queue without removing it
	 * from the queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7, 1, 3, 3, 5, 1),
	 * this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1)
	 * </pre>
	 * 
	 * If the queue is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
	public E peek() {
		if (this.head.getPointingNode() == null && this.tail.getPointingNode() ==null){
			throw new NoSuchElementException();
		}
		
		return this.head.getPointingNode().getValue();
	}

	/**
	 * Returns the number of objects in this queue.
	 * 
	 * @return
	 */
	public int size() {
		return this.size;
	}
}