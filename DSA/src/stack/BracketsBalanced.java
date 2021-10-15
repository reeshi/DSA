/*For a given a string expression containing only round brackets or parentheses,
 *check if they are balanced or not.
 *Brackets are said to be balanced if the bracket which opens last, closes first.
 * */
package stack;
import java.util.*;

public class BracketsBalanced {

	public static void main(String[] args) {
		
		System.out.println(isBalanced("{([}])}"));

	}

	public static boolean isBalanced(String expression) {
		Stack<Character> st = new Stack<>();

		for(int i=0; i<expression.length(); i++){
			char ch = expression.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{'){
				st.push(ch);
			}else if(ch == ')'){
				if(checker(st, '(', ch)){
					st.pop();
				}else{
					return false;
				}
			}else if(ch == ']'){
				if(checker(st, '[', ch)){
					st.pop();
				}else{
					return false;
				}
			}else{
				if(checker(st, '{', ch)){
					st.pop();
				}else{
					return false;
				}
			}
		}

		if(st.isEmpty()){
			return true;
		}else{
			return false;
		}

	}

	static boolean checker(Stack<Character> st, char ob, char cb){
		if(!st.isEmpty()){
			if(st.peek() == ob){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}
