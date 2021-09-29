/*Given a string S, compute recursively a new string where identical chars that are adjacent in the original string
 *are separated from each other by a "*".
 *
 *example: aaaa --> a*a*a*a
 *		   hello --> hel*lo
 * */
package recursionAssigment;

public class PairStar {

	public static void main(String[] args) {
		
		System.out.println(pairStar("h"));

	}
	
	static String pairStar(String str) {
		if(str.length() == 1) {
			return str;
		}
		
		String convertedString = pairStar(str.substring(1));
		
		if(str.charAt(0) == convertedString.charAt(0)) {
			return str.charAt(0) + "*" + convertedString;
		}else {
			return str.charAt(0) + convertedString;
		}
	}

}
