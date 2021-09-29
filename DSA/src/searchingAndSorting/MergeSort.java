package searchingAndSorting;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] arr = {2,6,8,5,4,3};
		
		mergeSort(arr);
		
		printArray(arr);
	}

	public static void mergeSort(int[] input){

		if(input.length <= 1){
			return;
		}

		int mid = (input.length-1)/2;

		int[] arr1 = new int[mid + 1];
		int[] arr2 = new int[input.length-1-mid];

		for(int i=0; i<mid+1; i++){
			arr1[i] = input[i];
		}

		for(int i=mid+1, j=0; i<input.length; i++){
			arr2[j++] = input[i];
		}

		mergeSort(arr1);
		mergeSort(arr2);

		mergeTwoSortedArrays(arr1, arr2, input);

	}

	static void mergeTwoSortedArrays(int[] arr1, int[] arr2, int[] res){
		int i=0, j=0, k=0;
		while(i < arr1.length && j < arr2.length){
			if(arr1[i] < arr2[j]){
				res[k] = arr1[i];
				k++;
				i++;
			}else{
				res[k] = arr2[j];
				k++;
				j++;
			}
		}

		while(i < arr1.length){
			res[k] = arr1[i];
			k++;
			i++;
		}

		while(j < arr2.length){
			res[k] = arr2[j];
			k++;
			j++;
		}
	}
	
	static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
