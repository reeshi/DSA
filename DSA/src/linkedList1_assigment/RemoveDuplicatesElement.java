/*You have been given a singly linked list of integers where the elements are sorted in ascending order.
 *Write a function that removes the consecutive duplicate values such that the given list only contains unique elements
 *and returns the head to the updated list.
 *
 * input : 1 -> 1 -> 2 -> 2 -> 2 -> 3 -> 3
 * output : 1 -> 2 -> 3
 * */
package linkedList1_assigment;

import java.util.Scanner;

import linkedList1.Node;

public class RemoveDuplicatesElement {

	public static void main(String[] args) {

		Node<Integer> head = takeInput();
		
		head = removeDuplicates(head);
		
		printLinkedList(head);
	}

	public static Node<Integer> removeDuplicates(Node<Integer> head) {
		// empty linkedList
		if(head == null){
			return head;
		}

		Node<Integer> prev = head;
		Node<Integer> curr = head.next;

		while(curr != null){
			if(curr.data > prev.data){
				prev.next = curr;
				curr = curr.next;
				prev = prev.next;
			}else{
				curr = curr.next;
			}
		}

		if(prev.next != null){
			prev.next = null;
		}

		return head;
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
