package DataStructures;

public class TestLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> myList = new LinkedList<Integer>();
		
		System.out.println(myList.isEmpty());
		myList.add(new Integer(3));
		System.out.println(myList.isEmpty());
		myList.add(new Integer(2));
		System.out.println(myList.getSize());
		myList.remove(new Integer(4));
		System.out.println(myList.getSize());
		myList.remove(new Integer(3));
		System.out.println(myList.getSize());
		myList.print();
	}

}
