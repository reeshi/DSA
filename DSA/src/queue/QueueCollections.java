package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollections {

	public static void main(String[] args) {
		// In collection framework the queue is interface
		// and this interface is implemented by LinkedList class.
		
		// since queue is interface , so we can make a referance variable of that 
		// But cannot create a object.
		// we can create a object of that class which implemented this interface.
		// In this case that class is LinkedList class.
		Queue<Integer> q = new LinkedList<>();
		
		q.add(10);// add at rear end.
		q.add(20);
		
		System.out.println(q.size()); 
		
		// use peek() function to see the element at front
		System.out.println(q.peek());
		
		// to remove the element at front we can use poll() OR remove() function
		// the differance between this is poll gives null if queue is empty but remove throw exception.
		System.out.println(q.poll());
		
		System.out.println(q.size());
		

	}

}
