/*Given a singly linked list of integers, sort it using 'Bubble Sort.
 * */
package linkedList2_assigment;

import java.util.Scanner;

import linkedList1.Node;

public class BubbleSortOnLL {

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		
		head = bubbleSort(head);
		
		printLinkedList(head);
	}

	public static Node<Integer> bubbleSort(Node<Integer> head) {
		// If linked list is empty.
		if(head == null){
			return head;
		}

		int len = length(head);
		
		// If Linked list has only one element.
		if(len == 1){
			return head;
		}

		for(int i=1; i<len; i++){
			Node<Integer> curr1 = head, prev = null;

			for(int j = 0; j < len - i; j++){
				Node<Integer> curr2 = curr1.next;
				if(curr1.data > curr2.data){
					//Swap.
					if(j == 0){
						curr1.next = curr2.next;
						curr2.next = curr1;
						head = curr2;
						prev = curr2;
					}else{
						prev.next = curr2;
						curr1.next = curr2.next;
						curr2.next = curr1;
						prev = curr2;
					}
					
				}else{
					prev = curr1;
					curr1 = curr1.next;
				}

			}
		}

		return head;
	}

	static int length(Node<Integer> head) {
		Node<Integer> temp = head;
		int length = 0;

		while(temp != null) {
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
