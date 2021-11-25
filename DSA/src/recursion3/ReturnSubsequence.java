// given a string return its all subsequence in array.
// abc -> "",a,b,c,ab,ac,bc,abc
package recursion3;

public class ReturnSubsequence {

	public static void main(String[] args) {
		
		String[] ans = returnSubsquence("abc");
		
		for(String s: ans) {
			System.out.print(s + " ");
		}

	}
	
	public static String[] returnSubsquence(String str){
		// Base case
		if(str.length() == 0) {
			String[] bres = new String[1];
			bres[0] = "";
			return bres;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		String[] smallerOutput = returnSubsquence(ros);
		
		String[] output = new String[smallerOutput.length * 2];
		
		// Not included
		for(int i=0; i<smallerOutput.length; i++) {
			output[i] = smallerOutput[i];
		}
		
		// include
		for(int i=0; i<smallerOutput.length; i++) {
			output[smallerOutput.length + i] = ch + smallerOutput[i];
		}
		
		return output;
	}

}
