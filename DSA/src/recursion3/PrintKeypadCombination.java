/*Given an integer n, using phone keypad find out and print all the possible strings
 *that can be made using digits of input n
 * */
package recursion3;

public class PrintKeypadCombination {

	public static void main(String[] args) {
		
		printKeypad(23, "");

	}
	
	static String[] key = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static void printKeypad(int input, String ansSoFar){
		if(input == 0 || input == 1){
			System.out.println(ansSoFar);
			return;
		}

		String option = key[input % 10 - 2];
		for(int i=0; i<option.length(); i++){
			printKeypad(input/10, option.charAt(i) + ansSoFar);
		}

	}

}
