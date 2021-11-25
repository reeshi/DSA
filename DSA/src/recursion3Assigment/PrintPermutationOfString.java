// Given a string, find and print all the possible permutations of the input string.
package recursion3Assigment;

public class PrintPermutationOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void permutations(String input){

		permutationsHelper(input, "");

	}

	public static void permutationsHelper(String input, String ans){
		if(input.length() == 0){
			System.out.println(ans);
			return;
		}

		for(int i=0; i<input.length(); i++){

			String ros = input.substring(0,i) + input.substring(i+1);

			permutationsHelper(ros, ans + input.charAt(i));
		}
	}

}
