/*You have been given a singly linked list of integers.
 *Write a function that returns the index/position of integer data denoted by 'N' (if it exists). Return -1 otherwise.
 * */
package linkedList1_assigment;

import java.util.Scanner;

import linkedList.Node;

public class FindNode {

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		
		int idx = findNode(head, 3);
		
		System.out.println(idx);

	}
	
	// return the index of the node if it is present else return -1. 
	public static int findNode(Node<Integer> head, int n) {
		// empty linkedList
		if(head == null){
			return -1;
		}

		Node<Integer> temp = head;
		int i = 0;

		while(temp != null){
			if(temp.data == n){
				return i;
			}
			i++;
			temp = temp.next;
		}

		return -1;
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
