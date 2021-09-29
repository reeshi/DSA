package arrays;

import java.util.Scanner;

public class FindDuplicateElement {

	public static void main(String[] args) {
		
		int[] input = takeArrayInput();
		
		System.out.println(duplicateNumber(input));

	}

	public static int duplicateNumber(int arr[]) {
		//Your code goes here
		int ans = 0;
		for(int i=0; i<arr.length; i++){
			boolean isRepeat = true;
			for(int j = i+1; j<arr.length; j++){
				if(arr[i] == arr[j]){
					ans = arr[i];
					isRepeat = false;
					break;
				}
			}

			if(isRepeat == false){
				break;
			}
		}

		return ans;
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
