package linkedList;

import java.util.Scanner;

public class LinkedListUse {

	public static Node<Integer> createLinkedList(){
		Node<Integer> n1 = new Node<Integer>(10);
		Node<Integer> n2 = new Node<Integer>(20);
		Node<Integer> n3 = new Node<Integer>(30);
		Node<Integer> n4 = new Node<Integer>(40);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		return n1;
	}

	static void printLinkedList(Node<Integer> head) {
		Node<Integer> temp = head;

		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	static void increment(Node<Integer> head) {
		Node<Integer> temp = head;

		while(temp != null) {
			temp.data++;
			temp = temp.next;
		}
	}

	// calculate length of a linked list
	static int length(Node<Integer> head) {
		Node<Integer> temp = head;
		int length = 0;

		while(temp != null) {
			length++;
			temp = temp.next;
		}

		return length;
	}

	// Print ith node of linked list
	public static void printIthNode(Node<Integer> head, int i){

		int len = length(head);
		if(i >= len){
			return;
		}

		Node<Integer> temp = head;
		int idx = 0;
		while(temp != null){
			if(idx == i){
				System.out.println(temp.data);
				return;
			}
			idx++;
			temp = temp.next;
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

	// Insert a node at ith location
	public static Node<Integer> insert(Node<Integer> head, int pos, int data){

		if(pos > length(head)){
			return head;
		}

		Node<Integer> currNode = new Node<>(data);
		if(pos == 0){
			currNode.next = head;
			head = currNode;
			return head;
		}

		int i=1;
		Node<Integer> prevNode = head;
		while(i < pos){
			prevNode = prevNode.next;
			i++;
		}

		Node<Integer> nextNode = prevNode.next;
		prevNode.next = currNode;
		currNode.next = nextNode;

		return head;
	}

	// Deleting the ith node of a linked list
	public static Node<Integer> deleteNode(Node<Integer> head, int pos) {

		if(pos >= length(head)){
			return head;
		}

		if(pos == 0){
			head = head.next;
			return head;
		}

		Node<Integer> prev = head;
		int i=0;
		while(i < pos-1){
			prev = prev.next;
			i++;
		}

		prev.next = prev.next.next;

		return head;
	}

	// Main function.
	public static void main(String[] args) {

		Node<Integer> head = takeInput();

//		head = insert(head, 2, 6);
		head = deleteNode(head, 0);

		printLinkedList(head);

		//		Node<Integer> n1 = new Node<Integer>(10);
		//		
		//		System.out.println(n1.data);
		//		System.out.println(n1.next);
		//		System.out.println(n1);

		//		Node<Integer> head = createLinkedList();
		//
		//		increment(head);
		//		System.out.println(length(head));
		//		printLinkedList(head);
		//		
		//		printIthNode(head, 0);

	}

}
