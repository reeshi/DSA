package queue;

public class QueueUse {

	public static void main(String[] args) throws QueueEmptyException{

		QueueUsingStack<Integer> q = new QueueUsingStack<>();

		//		for(int i=1; i<=100; i++) {
		//			q.enqueue(i * 10);
		//		}
		//		
		//		System.out.println("Size of the queue = " + q.size());
		//		System.out.println("Element at the front = " + q.front());
		//		
		//		while(!q.isEmpty()) {
		//			System.out.println(q.dequeue());
		//		}

		//		System.out.println(q.front());

		int[] arr = {10,20,30,40,50};
		for(int ele: arr) {
			q.enqueue(ele);
		}

		q.dequeue();
		q.dequeue();

		q.enqueue(60);
		q.enqueue(70);

		q.enqueue(80);
		q.enqueue(90);

		System.out.println("Size of the queue = " + q.size());
		System.out.println("Element at the front = " + q.front());

		while(!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
		

	}

}
