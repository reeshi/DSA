//Given an integer array (of length n), find and print all the subsets of input array.
package recursion3Assigment;

public class PrintSubsetOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void printSubsets(int input[]) {
		printSubsetsHelper(input, "", 0);
	}

	public static void printSubsetsHelper(int input[], String ans, int si){
		if(si >= input.length){
			System.out.println(ans);
			return;
		}

		// Included
		printSubsetsHelper(input, ans + input[si] +" ", si+1);

		// Not included
		printSubsetsHelper(input, ans, si+1);

	}

}
