/*You have been given a queue that can store integers as the data.
 *You are required to write a function that reverses the populated queue 
 *itself without using any other data structures.
 * */
package queueAssigment;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=5; i++) {
			q.add(i);
		}
		
		reverseQueue(q);
		
		for(int i: q) {
			System.out.println(i);
		}
	}
	
	// reversing a queue using recursion.
	public static void reverseQueue(Queue<Integer> input) {
		if(input.size() == 0){
			return;
		}

		int temp = input.poll();

		reverseQueue(input);

		input.add(temp);

	}

}
