package priorityQueue2;

import java.util.PriorityQueue;

public class InbuiltPQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// by deafult it is min priority Queue.
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		pq.add("reeshi");
		pq.add("abc");
		pq.add("def");
		pq.add("yadav");
		pq.add("a");
		
		while(!pq.isEmpty()) {
			System.out.println(pq.peek());
			pq.remove();
		}
	}

}
