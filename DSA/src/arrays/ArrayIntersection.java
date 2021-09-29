/*You have been given two integer arrays/list(ARR1 and ARR2) of size M and N, respectively.
 *You need to print their intersection;
 *An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words,
 *when there is a common value that exists in both the arrays/lists.
 * */
package arrays;

import java.util.Scanner;

public class ArrayIntersection {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr1 = new int[n];

		for(int i=0; i<arr1.length; i++) {
			arr1[i] = sc.nextInt();
		}
		
		int m = sc.nextInt();
		
		int[] arr2 = new int[m];
		
		for(int j=0; j<arr2.length; j++)
			arr2[j] = sc.nextInt();
		
		intersections(arr1, arr2);

	}
	
    public static void intersections(int arr1[], int arr2[]) {
    	//Your code goes here
        for(int i=0; i<arr1.length; i++){
            int ele = arr1[i];
            for(int j=0; j<arr2.length; j++){
                if(ele == arr2[j]){
                    System.out.print(ele + " ");
                    arr2[j] = Integer.MIN_VALUE;
                    break;
                }
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
			System.out.println(arr[i]);
		}
	}

}
