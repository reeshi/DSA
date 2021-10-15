/*You have been given two stacks that can store integers as the data.
 *Out of the two given stacks, one is populated and the other one is empty.
 *You are required to write a function that reverses the populated stack using the one which is empty.
 * */
package stack;
import java.util.*;

public class ReverseStack {

	public static void main(String[] args) {
		
		Stack<Integer> st = new Stack<>();
		st.push(5);
		st.push(4);
		st.push(3);
		st.push(2);
		st.push(1);
		
		reverseStack(st, new Stack<Integer>());
		
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}

	}

	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		//Your code goes here
		if(input.isEmpty()){
			return;
		}

		int temp = input.pop();

		// call recursion of n-1 elements of stack
		reverseStack(input, extra);

		while(!input.isEmpty()){
			extra.push(input.pop());
		}

		input.push(temp);

		while(!extra.isEmpty()){
			input.push(extra.pop());
		}

	}

}
