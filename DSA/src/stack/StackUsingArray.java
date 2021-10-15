package stack;

public class StackUsingArray {

	private int[] data;
	private int topIndex; // Index of the top most element of the stack.
	
	//constructor.
	public StackUsingArray() {
		data = new int[10];
		topIndex = -1;
	}

	// push the element at the top of the stack.
	public void push(int element) {
		topIndex++;
		if(topIndex == data.length) {
			doubleCapacity();
		}
		data[topIndex] = element;
	}
	
	// double the size 
	private void doubleCapacity() {
		int[] temp = new int[2 * data.length];
		
		for(int i=0; i<data.length; i++) {
			temp[i] = data[i];
		}
		
		data = temp;
	}

	// gives the top element
	public int top() throws StackEmptyException {
		if(!isEmpty()) {
			return data[topIndex];
		}else {
			// Throw a exception
			throw new StackEmptyException();
		}
	}
	
	// remove the top element.
	public int pop() throws StackEmptyException {
		if(!isEmpty()) {
			int removedEle = data[topIndex];
			topIndex--;
			return removedEle;
		}else {
			// Throw a exception
			throw new StackEmptyException();
		}
	}
	
	// give the size of the stack.
	public int size() {
		if(!isEmpty()) {
			return topIndex + 1;
		}else {
			return 0;
		}
	}
	
	// tells whether stack is empty or not.
	public boolean isEmpty() {
		if(topIndex != -1) {
			return false;
		}else {
			return true;
		}
	}

}
