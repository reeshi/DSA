/*You are given an array of integers that contain numbers in random order.
 *Write a program to find and return the number which occurs the maximum times in the given input
 *
 *If two or more elements contend for the maximum frequency,
 *return the element which occurs in the array first.
 * */
package hashmaps;

import java.util.HashMap;

public class MaximumFrequencyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,4,4,5};
		
		System.out.println("Maximum frequency number : " + maxFrequencyNumber(arr));
	}

	public static int maxFrequencyNumber(int[] arr){ 
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i=0; i<arr.length; i++){
			if(map.containsKey(arr[i])) {
				int val = map.get(arr[i]);
				++val;
				map.put(arr[i], val);
			}else {
				map.put(arr[i], 1);
			}
		}
		
		int maxCount = Integer.MIN_VALUE;
		int ans = -1;
		for(int i=0; i<arr.length; i++) {
			if(map.get(arr[i]) > maxCount) {
				maxCount = map.get(arr[i]);
				ans = arr[i];
			}
		}
		
		return ans;
	}

}
