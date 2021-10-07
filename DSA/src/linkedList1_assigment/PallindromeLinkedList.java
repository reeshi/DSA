/*You have been given a head to a singly linked list of integers.
 *Write a function check to whether the list given is a 'Palindrome' or not.
 * */
package linkedList1_assigment;

import java.util.Scanner;

import linkedList1.Node;

public class PallindromeLinkedList {

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		
		System.out.println(isPalindrome(head));

	}

	public static boolean isPalindrome(Node<Integer> head) {
		// empty linkedlist.
		if(head == null){
			return true;
		}
		
		// If length of a linkedList is one.
		if(head.next == null){
			return true;
		}

		int len = length(head);
		int mid = len / 2;

		Node<Integer> tail = head;
		int i=0;
		while(i < mid - 1){
			tail = tail.next;
			i++;
		}

		Node<Integer> newHead = reverseLL(tail.next);
		tail.next = null;

		Node<Integer> temp1 = head;
		Node<Integer> temp2 = newHead;

		while(temp1 != null && temp2 != null){
			if(temp1.data != temp2.data){
				return false;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		return true;

	}

	public static Node<Integer> reverseLL(Node<Integer> head){
		if(head.next == null){
			return head;
		}

		Node<Integer> prev = null;
		Node<Integer> curr = head;
		Node<Integer> temp = null;

		while(curr != null){
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		head = prev;
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
}
