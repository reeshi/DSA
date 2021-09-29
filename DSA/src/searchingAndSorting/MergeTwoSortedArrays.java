package searchingAndSorting;

import java.util.Scanner;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for(int i=0; i<arr1.length; i++)
			arr1[i] = sc.nextInt();
		
		int m = sc.nextInt();
		int[] arr2 = new int[m];
		for(int i=0; i<arr2.length; i++)
			arr2[i] = sc.nextInt();
		
		int[] res = mergeTwoSortedArrays(arr1, arr2);
		
		printArray(res);
	}
	
	static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		int res[] = new int[arr1.length+arr2.length];
		
		int i=0, j=0, k = 0;
		while(i <arr1.length && j < arr2.length) {
			if(arr1[i] < arr2[j]) {
				res[k] = arr1[i];
				i++;
				k++;
			}else {
				res[k] = arr2[j];
				j++;
				k++;
			}
		}
		
		while(i < arr1.length) {
			res[k] = arr1[i];
			i++;
			k++;
		}
		
		while(j < arr2.length) {
			res[k] = arr2[j];
			k++;
			j++;
		}
		
		return res;
	}
	
	static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
