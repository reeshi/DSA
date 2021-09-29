/*You have been given an integer array/list(ARR) of size N. Where N is equal to [2M + 1].
Now, in the given array/list, 'M' numbers are present twice and one number is present only once.
You need to find and return that number which is unique in the array/list.
 * */
package arrays;

import java.util.Scanner;

public class FindUniqueElements {

	public static void main(String[] args) {
		
		int[] input = takeArrayInput();
		
		System.out.println(findUniqueElement(input));
	}
	
	static int findUniqueElement(int[] arr) {
		int ans = 0;
		
		for(int i=0; i<arr.length; i++) {
			boolean isRepeat = false;
			for(int j=0; j<arr.length; j++) {
				if(i != j && arr[i] == arr[j]) {
					isRepeat = true;
					break;
				}
			}
			
			if(isRepeat == false) {
				ans = arr[i];
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
