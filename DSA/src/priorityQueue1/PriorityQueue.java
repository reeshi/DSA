// this is the implementation of MIN priority queue.
// the implementation of MAX priority queue almost similar to that.
package priorityQueue1;

import java.util.ArrayList;

public class PriorityQueue<T> {

	private ArrayList<Element<T>> heap;

	public PriorityQueue() {
		heap = new ArrayList<>();
	}


	// Insert in a priority
	public void insert(T value, int priority) {

		Element<T> e = new Element<>(value, priority);
		heap.add(e);

		int childIndex = heap.size()-1;
		int parentIndex = (childIndex-1)/2; // index of parent if childIndex is at ith is (i-1)/2.

		while(childIndex > 0) {
			if(heap.get(parentIndex).priority > heap.get(childIndex).priority) {
				// swap the child and parent.
				Element<T> temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);

				childIndex = parentIndex;
				parentIndex = (childIndex - 1)/2;
			}else {
				return;
			}
		}

	}

	// getMin function returns the least priority value.
	public T getMin() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0).value;
	}

	// removeMin function removes the least priority value and also return that removed value.
	public T removeMin() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}

		Element<T> removed = heap.get(0);
		T ans = removed.value;

		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);

		int parentIndex = 0;
		int leftChildIndex = 2*parentIndex+1;
		int rightChildIndex = 2*parentIndex+2;

		while(leftChildIndex < heap.size()) {
			int minIndex = parentIndex;
			if(heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
				minIndex = leftChildIndex;
			}

			if(rightChildIndex < heap.size() && (heap.get(rightChildIndex).priority < heap.get(minIndex).priority)) {
				minIndex = rightChildIndex;
			}

			if(minIndex == parentIndex) {
				break;
			}

			// swap
			Element<T> temp = heap.get(parentIndex);
			heap.set(parentIndex, heap.get(minIndex));
			heap.set(minIndex, temp);

			parentIndex = minIndex;
			leftChildIndex = 2*parentIndex+1;
			rightChildIndex = 2*parentIndex+2;
		}
		
		return ans;
	}

	// size function
	public int size() {
		return heap.size();
	}

	// isEmpty function
	public boolean isEmpty() {
		return heap.size() == 0;
	}
}
