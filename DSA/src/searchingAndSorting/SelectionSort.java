package searchingAndSorting;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		
		int[] input = takeArrayInput();
		
		selectionSort(input);
		
		printArray(input);

	}
	
	static void selectionSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			int min = i;
			for(int j= i+1; j<arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
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
