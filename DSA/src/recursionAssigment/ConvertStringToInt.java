/*Write a recursive function to convert a given string into the number it represents.
 *That is input will be a numeric string that contains only numbers,
 *you need to convert the string into corresponding integer and return the answer.
 * */
package recursionAssigment;

public class ConvertStringToInt {

	public static void main(String[] args) {
		
		System.out.println(convertStringToInt("0012345"));

	}

	public static int convertStringToInt(String input){

		if(input.length() == 1){
			return input.charAt(0) - '0';
		}

		int convertedCurrChar = input.charAt(0) - '0';

		int convertedRemStr = convertStringToInt(input.substring(1));

		int ans = convertedCurrChar * (int)Math.pow(10, input.length()-1) + convertedRemStr;

		return ans;

	}

}
