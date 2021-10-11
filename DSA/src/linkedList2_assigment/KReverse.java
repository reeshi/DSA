/*Given a singly linked list of integers,
 *reverse the nodes of the linked list 'k' at a time and return its modified list.
 'k' is a positive integer and is less than or equal to the length of the linked list.
 If the number of nodes is not a multiple of 'k,' then left-out nodes, in the end, should be reversed as well

 Given this linked list: 1 -> 2 -> 3 -> 4 -> 5

For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5

For k = 3, you should return: 3 -> 2 -> 1 -> 5 -> 4
 */
package linkedList2_assigment;

import java.util.Scanner;

import linkedList1.Node;

public class KReverse {

	public static void main(String[] args) {

		Node<Integer> head = takeInput();
		
		head = kReverse(head, 3);
		
		printLinkedList(head);

	}

	public static Node<Integer> kReverse(Node<Integer> head, int k) {
		if(head == null){
			return head;
		}

		Node<Integer> head1 = head, tail1 = head;
		for(int i=1; i<k && tail1.next != null; i++){
			tail1 = tail1.next;
		}

		Node<Integer> head2 = tail1.next;
		tail1.next = null;

		// reverse the K node and give its head. and the original linked list head becomes it tail
		Node<Integer> revHead = Reverse(head1);

		// Recursive call for remaning linked list.
		Node<Integer> smallHead = kReverse(head2, k);

		// head becomes tail after reversing the linked list.
		head1.next = smallHead;

		return revHead;
	}

	// Reverse the given linkedlist.
	static Node<Integer> Reverse(Node<Integer> head){
		Node<Integer> prev = null, curr = head, temp = null;

		while(curr != null){
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		return prev;
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
