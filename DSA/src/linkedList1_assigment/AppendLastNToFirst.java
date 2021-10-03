/*You have been given a singly linked list of integers along with an integer 'N'.
 *Write a function to append the last 'N' nodes towards the front of the singly linked list
 *and returns the new head to the list
 *
 * input : 1 -> 2 -> 3 -> 4 -> 5 , N = 3
 * output : 3 -> 4 -> 5 -> 1 -> 2
 * */
package linkedList1_assigment;

import java.util.Scanner;

import linkedList.Node;

public class AppendLastNToFirst {

	public static void main(String[] args) {

		Node<Integer> head = takeInput();
		
		head = appendLastNToFirst(head, 2);
		
		printLinkedList(head);

	}

	public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
		// empty linkedList OR n == 0
		if(head == null || n == 0){
			return head;
		}

		int len = length(head);
		if(len == 1 && n == 1){
			return head;
		}

		Node<Integer> tail = head;
		while(tail.next != null){
			tail = tail.next;
		}

		tail.next = head;

		Node<Integer> temp = head;
		int i=0;
		while(i < len-n-1){
			temp = temp.next;
			i++;
		}

		head = temp.next;
		temp.next = null;

		return head;

	}

	public static int length(Node<Integer> head){
		Node<Integer> temp = head;
		int length = 0;

		while(temp != null){
			length++;
			temp = temp.next;
		}

		return length;
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
