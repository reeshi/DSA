/*You have been given a singly linked list of integers along with two integers, 'i,' and 'j.'
 *Swap the nodes that are present at the 'i-th' and 'j-th' positions.
 *
 *Input : 3 -> 4 -> 5 -> 2 -> 6 -> 1 -> 9 -> null
 *		  i = 2 , j = 5
 *
 *output : 3 -> 4 -> 1 -> 2 -> 6 -> 5 -> 9 -> null
 * */
package linkedList2_assigment;

import java.util.Scanner;

import linkedList1.Node;

public class SwapTwoNodes {

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		
		head = swapNodes(head, 2, 5);
		
		printLinkedList(head);

	}

	public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
		if(head == null){
			return head;
		}else if(i == j){
			return head;
		}

		// swap two nodes from start;
		if(i == 0 && j-i == 1){
			Node<Integer> curr1 = head, curr2 = head.next;
			curr1.next = curr2.next;
			curr2.next = curr1;
			return curr2;
			
		}else if(i == 0){
			Node<Integer> curr1 = head, temp = head.next;
			Node<Integer> prev2 = null, curr2 = head;

			for(int q=0; q < j; q++){
				prev2 = curr2;
				curr2 = curr2.next;
			}
			curr1.next = curr2.next;
			curr2.next = temp;
			prev2.next = curr1;

			return curr2;
		}

		Node<Integer> prev1 = null, curr1 = head;
		for(int p=0; p<i; p++){
			prev1 = curr1;
			curr1 = curr1.next;
		}

		Node<Integer> prev2 = null, curr2 = head;
		for(int q=0; q < j; q++){
			prev2 = curr2;
			curr2 = curr2.next;
		}

		prev1.next = curr2;
		prev2.next = curr1;

		Node<Integer> temp = curr1.next;

		curr1.next = curr2.next;
		curr2.next = temp;

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
