/*For a given expression in the form of a string,
 *find the minimum number of brackets that can be reversed in order to make the expression balanced.
 *The expression will only contain curly brackets.
 *
 *If the expression can't be balanced, return -1.
 *
 *EXAMPLE :
 *			Expression: {{{{
			If we reverse the second and the fourth opening brackets, 
			the whole expression will get balanced.
			Since we have to reverse two brackets to make the expression balanced,
			the expected output will be 2
			
			Expression: {{{
			In this example, even if we reverse the last opening bracket,
			we would be left with the first opening bracket
			and hence will not be able to make the expression balanced and the output will be -1.
 * */
package stackAssigment;

import java.util.Stack;

public class MinimumBracketReversal {

	public static void main(String[] args) {
		
		System.out.println(countBracketReversals("{{{{}}"));
	}

	public static int countBracketReversals(String input) {
		if(input.length() % 2 != 0){
			return -1;
		}

		Stack<Character> st = new Stack<>();

		for(int i=0; i<input.length(); i++){
			char ch = input.charAt(i);

			if(ch == '}'){
				// if stack is empty than push closing brackets.
				if(st.isEmpty()){
					st.push(ch);
				}else if(!st.isEmpty() && st.peek() == '}'){
					// if stack is not empty and closing bracket is on the top of the stack than push closing bracket.
					st.push(ch);
				}else if(!st.isEmpty() && st.peek() == '{'){
					// if stack is not empty and on top opening bracket. 
					st.pop();
				}
			}else{
				st.push(ch);
			}
		}

		int count = 0;

		while(!st.isEmpty()){
			char c1 = st.pop();
			char c2 = st.pop();

			if(c1 == c2){
				count++;
			}else{
				count += 2;
			}
		}

		return count;
	}

}
