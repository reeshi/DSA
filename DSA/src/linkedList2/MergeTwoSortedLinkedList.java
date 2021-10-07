package linkedList2;

import java.util.Scanner;

import linkedList1.Node;

public class MergeTwoSortedLinkedList {

	public static void main(String[] args) {
		
		Node<Integer> head1 = takeInput();
		Node<Integer> head2 = takeInput();
		
		Node<Integer> head = mergeTwoSortedLinkedLists(head1, head2);
		
		printLinkedList(head);

	}
	
	// the approach is very similar to merge two sorted arrays. only differance is we are making changes in the given linkedlists.
    public static Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> head1, Node<Integer> head2) {

        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        
        Node<Integer> temp1 = head1, temp2 = head2;
        Node<Integer> head = null , tail = null;

        if(temp1.data < temp2.data){
            head = temp1;
            tail = temp1;
            temp1 = temp1.next;
        }else{
            head = temp2;
            tail = temp2;
            temp2 = temp2.next;
        }

        while(temp1 != null && temp2 != null){
            if(temp1.data < temp2.data){
                tail.next = temp1;
                tail = temp1;
                temp1 = temp1.next;
            }else{
                tail.next = temp2;
                tail = temp2;
                temp2 = temp2.next;
            }
        }
        
		// either one of them is over.
        if(temp1 != null){
            // if 1st list is not over.
            tail.next = temp1;
        }else{
            // if 2nd list is not over.
            tail.next = temp2;
        }
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
