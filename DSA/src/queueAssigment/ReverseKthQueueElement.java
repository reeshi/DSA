/*For a given queue containing all integer data, reverse the first K elements.
  You have been required to make the desired change in the input queue itself.
  
  Example : 
  			input : 1 2 3 4 5 , K = 3
  			output : 3 2 1 4 5
 * */
package queueAssigment;

import java.util.*;

public class ReverseKthQueueElement {

	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=5; i++) {
			q.add(i);
		}
		
		q = reverseKElements(q, 3);
		
		for(int i: q) {
			System.out.println(i);
		}

	}

	public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		if(k <= 1){
			return input;
		}

		Stack<Integer> st = new Stack<>();

		for(int i=0; i<k; i++){
			st.push(input.poll());
		}

		while(!st.isEmpty()){
			input.add(st.pop());
		}

		for(int i=0; i < input.size()-k; i++){
			input.add(input.poll());
		}

		return input;
	}

}
