/*
Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.

Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.

Output Format
The first and only line of output contains length of the longest subarray whose sum is zero.

Constraints:
0 <= N <= 10^8
Time Limit: 1 sec

Sample Input 1:
10 
 95 -97 -387 -435 -5 -70 897 127 23 284
Sample Output 1:
5
Explanation:
The five elements that form the longest subarray that sum up to zero are: -387, -435, -5, -70, 897 
*/
package hashmapassigment;

import java.util.HashMap;

public class LongestSubsetZeroSum {
	
	public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
		int maxLength = Integer.MIN_VALUE;
        
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            
            sum += arr[i];
            if(sum == 0){
                maxLength = Math.max(maxLength, i+1);
            }
            
            if(map.containsKey(sum)){
                int idx = map.get(sum);
                maxLength = Math.max(maxLength, i - idx);
            }else{
                map.put(sum, i);
            }
            
        }
        
        return maxLength;
	}

}
