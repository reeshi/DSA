package queue;

import linkedList1.Node;

public class QueueUsingLinkedList<T> {
	private Node<T> front;
	private Node<T> rear;
	int size;
	
	public QueueUsingLinkedList() {
		front = null;
		rear = null;
		size = 0;
	}
	
	public void enqueue(T element) {
		Node<T> newNode = new Node<>(element);
		
		if(size == 0) {
			front = newNode;
			rear = newNode;
		}else {
			rear.next = newNode;
			rear = rear.next;
		}
		
		size++;
	}
	
	public T front() throws QueueEmptyException {
		if(size == 0) {
			throw new QueueEmptyException();
		}
		return front.data;
	}
	
	public T dequeue() throws QueueEmptyException {
		if(size == 0) {
			throw new QueueEmptyException();
		}
		if(front == rear) {
			rear = null;
		}
		T temp = front.data;
		front = front.next;
		size--;
		return temp;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
