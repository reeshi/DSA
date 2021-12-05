// this is the implementation of Max Priority queue.
package priorityQueue1;

import java.util.ArrayList;

public class MaxPriorityQueue<T> {
	
	private ArrayList<Element<T>> heap;
	
	public MaxPriorityQueue() {
		heap = new ArrayList<>();
	}
	
	//Insert
	public void insert(T value, int priority) {
		Element<T> e = new Element<>(value, priority);
		
		heap.add(e);
		int childIndex = heap.size()-1;
		int parentIndex = (childIndex - 1)/2;
		
		while(childIndex > 0) {
			if(heap.get(childIndex).priority > heap.get(parentIndex).priority) {
				// swap
				Element<T> temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
			}else {
				return;
			}
			childIndex = parentIndex;
			parentIndex = (childIndex - 1)/2;
		}
		
	}
	
	//getMax -> returns the maximum priority value
	public T getMax() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		
		return heap.get(0).value;
	}
	
	// removeMax -> removed the max priority value and returns the value
	public T removeMax() throws PriorityQueueException {
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
			int maxIndex = parentIndex;
			if(heap.get(leftChildIndex).priority > heap.get(maxIndex).priority) {
				maxIndex = leftChildIndex;
			}
			
			if(rightChildIndex < heap.size() && (heap.get(rightChildIndex).priority > heap.get(maxIndex).priority)) {
				maxIndex = rightChildIndex;
			}
			
			if(maxIndex == parentIndex) {
				break;
			}
			
			Element<T> temp = heap.get(parentIndex);
			heap.set(parentIndex, heap.get(maxIndex));
			heap.set(maxIndex, temp);
			
			parentIndex = maxIndex;
			leftChildIndex = 2*parentIndex+1;
			rightChildIndex = 2*parentIndex+2;
		}
		
		return ans;
	}
	
	// size
	public int size() {
		return heap.size();
	}
	
	// isEmpty
	public boolean isEmpty() {
		return heap.size() == 0;
	}

}
