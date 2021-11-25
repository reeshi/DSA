/*Given an integer n, using phone keypad find out all the possible strings
 *that can be made using digits of input n.
 *Return empty string for numbers 0 and 1
 * */
package recursion3;

public class ReturnKeyPadCombination {

	public static void main(String[] args) {
		
		String[] ans = keypad(23);
		for(String s: ans) {
			System.out.println(s);
		}
	}
	
    static String[] key = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public static String[] keypad(int n){
		
        if(n == 0 || n == 1){
            String[] output = new String[1];
            output[0] = "";
            return output;
        }
        
        String[] smallerOutput = keypad(n / 10);
        
        String option = key[n % 10 - 2];
        String[] output = new String[smallerOutput.length * option.length()];
        
        int k = 0;
        for(int i=0; i<smallerOutput.length; i++){
            for(int j=0; j<option.length(); j++){
                output[k++] = smallerOutput[i] + option.charAt(j);
            }
        }
        
        return output;
	}

}
