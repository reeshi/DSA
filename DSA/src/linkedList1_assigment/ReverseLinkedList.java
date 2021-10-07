/*You have been given a singly linked list of integers. Write a function to print the list in a reverse order.
To explain it further, you need to start printing the data from the tail and move towards the head of the list,
printing the head data at the end.
 * */
package linkedList1_assigment;

import java.util.Scanner;

import linkedList1.Node;

public class ReverseLinkedList {

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		
		printReverse(head);
	}
	
	// we can do this problem using another approach. In that approach the state of the linkedlist will change.
	public static void printReverse(Node<Integer> root) {
		if(root == null){
            return;
        }
		
        printReverse(root.next);
        
        System.out.print(root.data + " ");
        
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
