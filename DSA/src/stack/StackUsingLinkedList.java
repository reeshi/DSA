package stack;

import linkedList1.Node;

public class StackUsingLinkedList<T> {

	private Node<T> head;
	private int size;

	public StackUsingLinkedList() {
		head = null;
		size = 0;
	}

	// Insert the element at the top.
	// we insert the new node in the beginning.
	// so that all the operation is going to be O(1).
	public void push(T element) {
		Node<T> newNode = new Node<>(element);
		newNode.next = head;
		head = newNode;
		size++;
	}

	// Return the top element in the stack.
	public T top() throws StackEmptyException {
		// If we try to call top on empty stack.
		if(head == null) {
			// Throw stackEmptyException.
			throw new StackEmptyException();
		}
		return head.data;
	}

	// Remove the top element in the stack.
	public T pop() throws StackEmptyException {
		// If we try to remove element on empty stack.
		if(head == null) {
			// Throw stackEmptyException.
			throw new StackEmptyException();
		}
		T data = head.data;
		head = head.next;
		size--;
		return data;
	}

	// Return the size of the stack
	public int size() {
		return size;
	}

	// tell's stack is empty or not.
	public boolean isEmpty() {
		return size == 0;
	}
}
