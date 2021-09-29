package searchingAndSorting;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++)
			arr[i] = sc.nextInt();
		
		int x = sc.nextInt();
		
		System.out.println(binarySearch(arr, x));

	}
	
	static int binarySearch(int[] arr, int x) {
		int start = 0, end = arr.length-1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(arr[mid] < x) {
				start = mid + 1;
			}else if(arr[mid] > x) {
				end = mid - 1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}
}
