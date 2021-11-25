// given a string print its all subsequnece.
// abc -> "",a,b,c,ab,ac,bc,abc
package recursion3;

public class PrintSubsequence {

	public static void main(String[] args) {
		
		printSubsequence("abc", "");

	}
	
	public static void printSubsequence(String input, String subsequenceSoFar) {
		if(input.length() == 0) {
			System.out.println(subsequenceSoFar);
			return;
		}
		
		// Not include.
		printSubsequence(input.substring(1), subsequenceSoFar);
		
		// include.
		printSubsequence(input.substring(1), subsequenceSoFar + input.charAt(0));
	}

}
