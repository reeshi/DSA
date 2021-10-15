package stack;

import java.util.Stack;

public class StackCollections {

	public static void main(String[] args) {
		
		Stack<Integer> st = new Stack<>();
		
		for(int i=1; i<=100; i++) {
			st.push(i * 10);
		}
		
		System.out.println("Element at the top = " + st.peek());
		System.out.println("Size of st = " + st.size());
		
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}

}
