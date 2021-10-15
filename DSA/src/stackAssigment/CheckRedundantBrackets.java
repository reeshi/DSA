/*For a given expression in the form of a string, find if there exist any redundant brackets or not.
 *It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.
 *
  A pair of the bracket is said to be redundant
  when a sub-expression is surrounded by unnecessary or needless brackets.
  
  EXAMPLE :
  		Expression: (a+b)+c
		Since there are no needless brackets, hence, the output must be 'false'.
		
		Expression: ((a+b))
		The expression can be reduced to (a+b).
 		Hence the expression has redundant brackets and the output will be 'true'.
 * */
package stackAssigment;

import java.util.Stack;

public class CheckRedundantBrackets {

	public static void main(String[] args) {

		System.out.println(checkRedundantBrackets("((a+b))"));

	}

	public static boolean checkRedundantBrackets(String expression) {
		Stack<Character> st = new Stack<>();

		for(int i=0; i<expression.length(); i++){
			char ch = expression.charAt(i);
			if(ch == ')'){
				// count no. of variable between this brackets.
				int count = 0;
				// pop till we encounter opening bracket on the top
				while(st.peek() != '('){
					st.pop();
					count++;
				}
				// if count is less than 1.
				// which means that this two brackets are redundant.
				if(count <= 1){
					return true;
				}
				// also pop the opening bracket.
				st.pop();
			}else{
				st.push(ch);
			}
		}
		
		// If we program come at this stage it means stack is empty 
		// and if stack is empty than there is no redundant brackets in it.
		// that's why return false.
		return false;
	}

}
