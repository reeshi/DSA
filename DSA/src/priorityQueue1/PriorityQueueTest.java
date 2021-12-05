package priorityQueue1;

public class PriorityQueueTest {

	public static void main(String[] args) throws PriorityQueueException {
		// TODO Auto-generated method stub
//		PriorityQueue<String> pq = new PriorityQueue<>();
//		
//		pq.insert("abc", 15);
//		pq.insert("def", 10);
//		pq.insert("reeshi", 100);
//		pq.insert("yadav", 120);
//		
//		while(!pq.isEmpty()) {
//			System.out.println(pq.getMin());
//			pq.removeMin();
//		}
		
		MaxPriorityQueue<String> pq = new MaxPriorityQueue<>();
		
		pq.insert("reeshi", 10);
		pq.insert("yadav", 100);
		pq.insert("abc", 23);
		pq.insert("def", 101);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.getMax());
			pq.removeMax();
		}
		
	}

}
