package arrays;

import java.util.Scanner;


public class ArrayIntro{

	public static void main(String[] args) {
		
		int[] input = takeArrayInput();
		
		printArray(input);
		
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
			System.out.println(arr[i]);
		}
	}

}
