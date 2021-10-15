package stack;

public class StackUse {

	public static void main(String[] args) throws StackEmptyException {
		
//		StackUsingArray st = new StackUsingArray();
//		
//		for(int i=1; i<=100; i++) {
//			st.push(i * 10);
//		}
//		
//		System.out.println("element at the top = " + st.top());
//		System.out.println("Size of stack = " + st.size());
//		
//		while(!st.isEmpty()) {
//			System.out.print(st.pop() + " ");
//		}
		
		StackUsingLinkedList<Integer> st = new StackUsingLinkedList<>();
		
		for(int i=1; i<=100; i++) {
			st.push(i * 10);
		}
		
		System.out.println("Element at the top = " + st.top());
		System.out.println("Size of the stack = " + st.size());
		
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}

}
