package linkedList2;

import java.util.Scanner;

import linkedList1.Node;

public class DeleteNodeRecursive {

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		
		head = deleteNodeRec(head, 6);
		
		printLinkedList(head);

	}
	
	public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) {
    	if(head == null){
            return head;
        }
        
        if(pos == 0){
            return head.next;
        }else{
          	head.next = deleteNodeRec(head.next, pos-1);
        	return head;
        }
	}

	// take input in linked list until the user enter -1.
	public static Node<Integer> takeInput(){
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();

		Node<Integer> head = null;
		Node<Integer> temp = null;
		while(data != -1) {
			Node<Integer> currNode = new Node<Integer>(data);

			if(head == null) {
				// Make this node as a head
				head = currNode;
				temp = head;
			}else {

				temp.next = currNode;
				temp = temp.next;

				//				Node<Integer> tail = head;
				//
				//				while(tail.next != null) {
				//					tail = tail.next;
				//				}
				//
				//				// Now tail will refer to the last node
				//				// connect current node after the last node
				//				tail.next = currNode;
			}

			data = sc.nextInt();
		}

		return head;
	}

	static void printLinkedList(Node<Integer> head) {
		Node<Integer> temp = head;

		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
