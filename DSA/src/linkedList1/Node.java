package linkedList1;

public class Node<T> {
	// making public beacuse it will be visible in entire project.
	public T data;
	public Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}

}
