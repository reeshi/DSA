/*Given an array of n positive integers and a number k. 
 *Find the minimum number of swaps required to bring all the numbers less than or equal to k together.
 *
 *Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
  Output: 1

  Explanation: 
  To bring elements 2, 1, 3 together, swap 
  element '5' with '3' such that final array
  will be - arr[] = {2, 1, 3, 6, 5}
 * */
package slidingWindow;

public class MinimumSwapsRequiredToBring {

	public static void main(String[] args) {

		int arr[] = {2, 7, 9, 5, 8, 7, 4};
		int k = 5;

		System.out.println(minimumSwapsRequiredToBringLessThanEqualToKTogether(arr, k));

	}

	static int minimumSwapsRequiredToBringLessThanEqualToKTogether(int[] arr, int k) {
		// count the element which are less than or equal to k.
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] <= k){
				count++;
			}
		}

		// Find unwanted elements in current
		// window of size 'count'
		int bad = 0;
		for(int i=0; i<count; i++) {
			if(arr[i] > k) {
				bad++;
			}
		}

		// Initialize answer with 'bad' value of
		// current window
		int ans = bad;
		for(int i=0, j=count; j<arr.length; i++,j++) {

			// Decrement count of previous window
			if(arr[i] > k) {
				bad--;
			}

			// Increment count of current window
			if(arr[j] > k) {
				bad++;
			}

			// Update ans if count of 'bad'
			// is less in current window
			ans = Math.min(ans, bad);
		}

		return ans;
	}

}
