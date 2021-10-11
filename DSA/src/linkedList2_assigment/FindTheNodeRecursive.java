/*Given a singly linked list of integers and an integer n,
 *find and return the index for the first occurrence of 'n' in the linked list. -1 otherwise.
 * */
package linkedList2_assigment;

import java.util.Scanner;

import linkedList1.Node;

public class FindTheNodeRecursive {

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		
		System.out.println(findNode(head, 0, 400));

	}
	
	// approach is very similar to find a element in array.
	public static int findNode(Node<Integer> head, int idx, int n){
		if(head == null){
			return -1;
		}

		if(head.data == n){
			return idx;
		}else{
			return findNode(head.next, idx + 1, n);
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

}
