package linkedList2;

import java.util.Scanner;

import linkedList1.Node;

public class MergeSortLinkedList {

	public static void main(String[] args) {

		Node<Integer> head = takeInput();
		
		head = mergeSort(head);
		
		printLinkedList(head);

	}

	public static Node<Integer> mergeSort(Node<Integer> head) {
		// if list is empty OR only one element in the list.
		if(head == null || head.next == null){
			return head;
		}

		// mid of the linkedlist.
		Node<Integer> midNode = mid(head);

		// split the linkedlist into two parts.
		Node<Integer> part1Head = head;
		Node<Integer> part2Head = midNode.next;
		midNode.next = null;

		// calling mergeSort on this two sorted linkedlist.
		Node<Integer> head1 = mergeSort(part1Head);
		Node<Integer> head2 = mergeSort(part2Head);

		// merge two sorted linkedlist.
		Node<Integer> sortedHead = mergeTwoSortedLinkedList(head1, head2);

		return sortedHead;
	}

	static Node<Integer> mergeTwoSortedLinkedList(Node<Integer> head1, Node<Integer> head2){
		if(head1 == null){
			return head2;
		}
		if(head2 == null){
			return head1;
		}
		Node<Integer> t1 = head1, t2 = head2;
		Node<Integer> head = null , tail = null;

		if(t1.data <= t2.data){
			head = t1;
			tail = t1;
			t1 = t1.next;
		}else{
			head = t2;
			tail = t2;
			t2 = t2.next;
		}

		while(t1 != null && t2 != null){
			if(t1.data <= t2.data){
				tail.next = t1;
				tail = t1;
				t1 = t1.next;
			}else{
				tail.next = t2;
				tail = t2;
				t2 = t2.next;
			}
		}

		if(t1 != null){
			tail.next = t1;
		}else{
			tail.next = t2;
		}

		return head;
	}

	static Node<Integer> mid(Node<Integer> head){
		if(head == null){
			return head;
		}

		Node<Integer> slow = head;
		Node<Integer> fast = head;

		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
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
