// operation of queue:
// 1. enqueue - insert the element at the rear end of the queue.
// 2. front - gives the front element.
// 3. dequeue - remove the front element.
package queue;

public class QueueUsingArray {

	private int[] data;
	private int front; // index of the element at the front of the queue.
	private int rear; // index of the element at the end of the queue.
	private int size;
	
	public QueueUsingArray() {
		data = new int[5];
		front = -1;
		rear = -1;
	}
	
	public void enqueue(int element) {
		if(size == data.length) {
			doubleCapacity();
		}
		
		if(front == -1) {
			front = 0;
		}
		
//		rear++;
//		// circular queue
//		if(rear == data.length) {
//			rear = 0;
//		}
		
		// we can also write this way.
		rear = (rear + 1) % data.length;
		data[rear] = element;
		size++;
	}
	
	public void doubleCapacity() {
		int[] temp = data;
		data = new int[2 * temp.length];
		
		// copying elements from front to end.
		int index = 0;
		for(int i=front; i < temp.length; i++) {
			data[index++] = temp[i];
		}
		
		// Now, copying elements from 0 to front-1;
		for(int i=0; i <= front-1; i++) {
			data[index++] = temp[i];
		}
		
		front = 0;
		rear = temp.length-1;
	}
	
	public int front() throws QueueEmptyException {
		if(size == 0) {
			throw new QueueEmptyException();
		}
		return data[front];
	}
	
	public int dequeue() throws QueueEmptyException {
		if(size == 0) {
			// Throw queue empty exception.
			throw new QueueEmptyException();
		}
		int temp = data[front];
//		front++;
//		// circular queue
//		if(front == data.length) {
//			front = 0;
//		}
		
		// We can also write this way.
		front = (front + 1) % data.length;
		size--;
		if(size == 0) {
			front = -1;
			rear = -1;
		}
		return temp;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

}
