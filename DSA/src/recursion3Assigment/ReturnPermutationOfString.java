/*
Given a string, find and return all the possible permutations of the input string.
Note : The order of permutations are not important.

Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba
 */
package recursion3Assigment;

import java.util.ArrayList;

public class ReturnPermutationOfString {

	public static void main(String[] args) {

		String[] ans = returnPermutation2("abc");

		for(String s: ans) {
			System.out.println(s);
		}

	}

	// 1st approach.
	public static String[] returnPermutation(String input) {
		//If string is empty than there is only one permutation of that string i.e empty string.
		if(input.length() == 0) {
			return new String[1];
		}

		if(input.length() == 1) {
			String[] output = new String[1];
			output[0] = input;
			return output;
		}

		ArrayList<String> output = new ArrayList<>();
		for(int i=0; i<input.length(); i++) {
			String ros = input.substring(0,i) + input.substring(i+1);
			String[] smallerOutput = returnPermutation(ros);

			for(int j=0; j<smallerOutput.length; j++) {
				output.add(input.charAt(i) + smallerOutput[j]);
			}
		}

		String[] ans = new String[output.size()];
		for(int i=0; i<output.size(); i++) {
			ans[i] = output.get(i);
		}

		return ans;

	}
	
	// 2nd approach.
	public static String[] returnPermutation2(String input) {
		//If string is empty than there is only one permutation of that string i.e empty string.
		if(input.length() == 0) {
			return new String[1];
		}

		if(input.length() == 1) {
			String[] output = new String[1];
			output[0] = input;
			return output;
		}

		char ch = input.charAt(0);
		String ros = input.substring(1);
		
		String[] smallerOutput = returnPermutation2(ros);
		String[] output = new String[input.length() * smallerOutput.length];
		int k=0;
		for(int i=0; i<smallerOutput.length; i++) {
			String newStr = smallerOutput[i];
			for(int j=0; j<newStr.length(); j++) {
				output[k++] = newStr.substring(0,j) + ch + newStr.substring(j); 
			}
			output[k] = newStr + ch;
			k++;
		}
		
		return output;

	}

}
