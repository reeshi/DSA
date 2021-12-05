package priorityQueue2;

public class HeapSort {
	
	public static void main(String[] args) {
		int arr[] = {2,10,5,8,1};
		
		inplaceHeapSort(arr);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

	public static void inplaceHeapSort(int arr[]) {
		// build a heap
		// if there are n nodes in complete binary tree than n/2 are non-leaf nodes.
		// n-n/2 is leaf nodes.
		int n = arr.length;
		for(int i = (n/2)-1; i >= 0; i--){
			downHeapify(arr, i, n);
		}

		// removeMin to sort the array.
		for(int i=n-1; i>=0; i--){
			// swap
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			downHeapify(arr, 0, i);
		}


	}

	public static void downHeapify(int arr[], int parentIndex, int end){
		int leftChildIndex = 2*parentIndex+1;
		int rightChildIndex = 2*parentIndex+2;

		while(leftChildIndex < end){
			int minIndex = parentIndex;
			if(arr[leftChildIndex] < arr[minIndex]){
				minIndex = leftChildIndex;
			}

			if(rightChildIndex < end && (arr[rightChildIndex] < arr[minIndex])){
				minIndex = rightChildIndex;
			}

			if(minIndex == parentIndex){
				return;
			}

			int temp = arr[minIndex];
			arr[minIndex] = arr[parentIndex];
			arr[parentIndex] = temp;

			parentIndex = minIndex;
			leftChildIndex = 2*parentIndex+1;
			rightChildIndex = 2*parentIndex+2;

		}
	}

}
