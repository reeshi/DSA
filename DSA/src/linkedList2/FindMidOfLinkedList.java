// Find the mid element in a linked List without calculating the length.
package linkedList2;

import java.util.Scanner;

import linkedList1.Node;

public class FindMidOfLinkedList {

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		
		Node<Integer> midNode = midPoint(head);
		
		System.out.println(midNode.data);

	}

	// fast and slow pointer approach.
	public static Node<Integer> midPoint(Node<Integer> head) {
		if(head == null){
			return head;
		}

		Node<Integer> slow = head;
		Node<Integer> fast = head;

		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;

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
}
