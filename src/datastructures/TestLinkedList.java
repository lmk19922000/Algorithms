package datastructures;

public class TestLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList2<Integer> myList = new LinkedList2<Integer>();
		
		myList.append(new Integer(3));
		myList.append(new Integer(4));
		myList.append(new Integer(5));
		myList.append(new Integer(6));
		myList.append(new Integer(7));
		myList.append(new Integer(8));
		myList.append(new Integer(9));
		
		myList.reverseList();
		
		System.out.println(findMiddleNode(myList).getValue());
//		myList.printList();
	}

	public static ListNode<Integer> findMiddleNode(LinkedList2<Integer> list){
		ListNode<Integer> curLast = list.getHead();
		ListNode<Integer> curMiddle = list.getHead();
		
		while (curLast != null && curLast.getNext() != null){
				curLast  = curLast.getNext().getNext();
				curMiddle = curMiddle.getNext();
		}
		
		return curMiddle;
	}
}
