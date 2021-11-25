// Given an integer array (of length n),
//find and return all the subsets of input array in the 2D-Array.
// 
package recursion3Assigment;

public class ReturnSubsetOfArray {

	public static void main(String[] args) {
		int[] arr = {15,20,12};
		int[][] ans = Subset(arr);
		
		for(int i=0; i<ans.length; i++) {
			for(int j=0; j<ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	public static int[][] Subset(int[] arr){
		return SubsetHelper(arr, 0);
	}
	
	public static int[][] SubsetHelper(int[] arr, int si){
		if(si == arr.length) {
			return new int[1][0];
		}
		
		int[][] smallerOutput = SubsetHelper(arr, si + 1);
		
		int[][] output = new int[2 * smallerOutput.length][];
		
		// Not included.
		for(int i=0; i<smallerOutput.length; i++) {
			output[i] = new int[smallerOutput[i].length];
			
			int[] temp = smallerOutput[i];
			for(int j=0; j<temp.length; j++) {
				output[i][j] = temp[j];
			}
		}
		
		// Included.
		for(int i=0; i<smallerOutput.length; i++) {
			output[i + smallerOutput.length] = new int[smallerOutput[i].length + 1];
			output[i + smallerOutput.length][0] = arr[si];
			
			int[] temp = smallerOutput[i];
			for(int j=1; j<=temp.length; j++) {
				output[i + smallerOutput.length][j] = temp[j-1];
			}
		}
		
		return output;
		
	}

}
