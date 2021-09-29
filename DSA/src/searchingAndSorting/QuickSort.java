package searchingAndSorting;

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = {5,4,3,2,1};
		
		quickSort(arr, 0, arr.length-1);
		
		printArray(arr);
	}

	static void quickSort(int[] arr, int si, int ei){
		if(si >= ei){
			return;
		}

		int pivot = arr[ei];

		int pi = partition(arr, si, ei, pivot);

		quickSort(arr, si, pi-1);
		quickSort(arr, pi+1, ei);

	}

	static int partition(int[] arr, int si, int ei, int pivot){
		int i=si, j=si;

		while(i <= ei){
			if(arr[i] > pivot){
				i++;
			}else if(arr[i] <= pivot){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j++;
			}
		}

		return j-1;
	}
	
	static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
