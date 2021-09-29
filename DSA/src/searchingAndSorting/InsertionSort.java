package searchingAndSorting;

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		
		int[] input = takeArrayInput();
		
		insertionSort(input);
		
		printArray(input);

	}
	
	static void insertionSort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			for(int j=i-1; j>=0 && arr[j] > arr[j+1]; j--) {
				int temp = arr[j+1];
				arr[j+1] = arr[j];
				arr[j] = temp;
			}
		}
	}
	
	static int[] takeArrayInput() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		return arr;
	}
	
	static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
