package jp.co.wap.exam;

public class TestPersistentQueue {
	public static void main(String[] args) {
		PersistentQueue<Integer> fasterQueue1, fasterQueue2, fasterQueue3, fasterQueue4, fasterQueue5, fasterQueue6, fasterQueue7;
		PersistentQueue2<Integer> slowQueue1, slowQueue2, slowQueue3, slowQueue4, slowQueue5, slowQueue6, slowQueue7;
		
		long startTime, endTime;
		
		fasterQueue1 = new PersistentQueue<Integer>();
		fasterQueue2 = fasterQueue1.enqueue(new Integer(1));
		fasterQueue3 = fasterQueue2.enqueue(new Integer(3));
		fasterQueue4 = fasterQueue3.enqueue(new Integer(5));
		fasterQueue5 = fasterQueue4.enqueue(new Integer(7));		
		fasterQueue6 = fasterQueue5.enqueue(new Integer(9));
		
		slowQueue1 = new PersistentQueue2<Integer>();
		slowQueue2 = slowQueue1.enqueue(new Integer(1));
		slowQueue3 = slowQueue2.enqueue(new Integer(3));
		slowQueue4 = slowQueue3.enqueue(new Integer(5));
		slowQueue5 = slowQueue4.enqueue(new Integer(7));		
		slowQueue6 = slowQueue5.enqueue(new Integer(9));
		
		startTime = System.nanoTime();
		fasterQueue7 = fasterQueue6.enqueue(new Integer(11));
		endTime = System.nanoTime();
		System.out.print("Enqueue time of fast PersistentQueue: ");
		System.out.println(endTime - startTime);
				
		startTime = System.nanoTime();
		slowQueue7 = slowQueue6.enqueue(new Integer(11));
		endTime = System.nanoTime();
		System.out.print("Enqueue time of slow PersistentQueue: ");
		System.out.println(endTime - startTime);
		
		startTime = System.nanoTime();
		fasterQueue7 = fasterQueue6.dequeue();
		endTime = System.nanoTime();
		System.out.print("Dequeue time of fast PersistentQueue: ");
		System.out.println(endTime - startTime);
				
		startTime = System.nanoTime();
		slowQueue7 = slowQueue6.dequeue();
		endTime = System.nanoTime();
		System.out.print("Dequeue time of slow PersistentQueue: ");
		System.out.println(endTime - startTime);
	}
	
}
