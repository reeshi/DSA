/*You have been given a random integer array/list(ARR) and a number X.
 *Find and return the number of Pair in the array/list which sum to X.
 * */
package arrays;

import java.util.Scanner;

public class PairSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int x = sc.nextInt();
		
		System.out.println(pairSum(arr, x));

	}
	
    public static int pairSum(int arr[], int x) {
    	int count = 0;
        
        for(int i=0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == x){
                    count++;
                }
            }
        }
        
        return count;
    }

}
