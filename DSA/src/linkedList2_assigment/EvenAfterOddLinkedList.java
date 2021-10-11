/*For a given singly linked list of integers,
 *arrange the elements such that all the even numbers are placed after the odd numbers.
 *The relative order of the odd and even terms should remain unchanged.
 *
 *input : 4 -> 2 -> 7 -> 8 -> 3 -> 36
 *output : 7 -> 3 -> 4 -> 2 -> 8 -> 36.
 * */
package linkedList2_assigment;

import java.util.Scanner;

import linkedList1.Node;

public class EvenAfterOddLinkedList {

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		
		head = evenAfterOdd(head);
		
		printLinkedList(head);

	}

	// the approach is very similar to take input in linkedList until -1 problem.
	public static Node<Integer> evenAfterOdd(Node<Integer> head) {
		Node<Integer> oddH = null, oddT = null, evenH = null, evenT = null;

		while(head != null){
			// if data is odd
			if(head.data % 2 != 0){
				if(oddH == null){
					oddH = head;
					oddT = head;
				}else{
					oddT.next = head;
					oddT = head;
				}
			}else{ // if data is even.
				if(evenH == null){
					evenH = head;
					evenT = head;
				}else{
					evenT.next = head;
					evenT = head;
				}
			}

			head = head.next;
		}

		// if the all data is even OR odd 
		if(oddT == null){
			return evenH;
		}else if(evenT == null){
			return oddH;
		}else{
			oddT.next = evenH;
			evenT.next = null;
			return oddH;
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
