/*
Given an array A of size n and an integer K, return all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important.

Input format :
Line 1 : Integer n, Size of input array
Line 2 : Array elements separated by space
Line 3 : K 

Constraints :
1 <= n <= 20

Sample Input :
9 
5 12 3 17 1 18 15 3 17 
6
Sample Output :
3 3
5 1
*/
package recursion3Assigment;

public class ReturnSubsetOfSumToK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,12,3,17,1,18,15,3,17};
		
		int[][] ans = subsetSum(arr, 6);
		
		for(int i=0; i<ans.length; i++) {
			for(int j=0; j<ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] subsetSum(int[] input, int k){
		return subsetSumHelper(input, k, 0);
	}
	
	public static int[][] subsetSumHelper(int[] input, int k, int si){
        //Base case - If startIndex == input.length
        //We can have two cases in the base condition
        //1. If k==0 - This means the desired sum has been achieved by including the last element of the input array
        //2. If k!=0 - Desired sum has not been achieved even when last element is included
		if(si == input.length) {
			if(k == 0) {
				return new int[1][0];
			}else {
				return new int[0][0];
			}
		}
		
		// Not included.
		int[][] smallerOutput1 = subsetSumHelper(input, k, si + 1);
		
		// Included.
		int[][] smallerOutput2 = subsetSumHelper(input, k-input[si], si + 1);
		
		int[][] output = new int[smallerOutput1.length + smallerOutput2.length][];
		
		// we have to just copy the not included answer in output array.
		// but for included , we have to add the element at index si in the output array
		//at the starting.
		
		for(int i=0; i<smallerOutput1.length; i++) {
			output[i] = new int[smallerOutput1[i].length];
			int[] temp = smallerOutput1[i];
			for(int j=0; j<temp.length; j++) {
				output[i][j] = temp[j];
			}
		}
		
		for(int i=0; i<smallerOutput2.length; i++) {
			output[i + smallerOutput1.length] = new int[smallerOutput2[i].length + 1];
			output[i + smallerOutput1.length][0] = input[si];
			
			int[] temp = smallerOutput2[i];
			for(int j=1; j<temp.length + 1; j++) {
				output[i + smallerOutput1.length][j] = temp[j-1];
			}
		}
		
		return output;
		
	}

}
