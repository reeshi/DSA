package queue;

import java.util.Stack;

public class QueueUsingStack<T> {
	private Stack<T> s1;
	private Stack<T> s2;
	
	public QueueUsingStack() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	
	public void enqueue(T element) {
		s1.push(element);
	}
	
	public T dequeue() throws QueueEmptyException {
		if(s1.isEmpty()) {
			throw new QueueEmptyException();
		}
		// push s1 element in s2 till s1 size becomes 1.
		while(s1.size() != 1) {
			s2.push(s1.pop());
		}
		
		T temp = s1.pop();
		
		// push the s2 element in s1 stack.
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		
		return temp;
	}
	
	public T front() throws QueueEmptyException {
		if(s1.isEmpty()) {
			throw new QueueEmptyException();
		}
		// push s1 element in s2 till s1 size becomes 1.
		while(s1.size() != 1) {
			s2.push(s1.pop());
		}
		
		T temp = s1.peek();
		
		// push the s2 element in s1 stack.
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		
		return temp;
	}
	
	public int size() {
		return s1.size();
	}
	
	public boolean isEmpty() {
		return s1.isEmpty();
	}
}
