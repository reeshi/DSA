/*You have been given a singly linked list of integers along with two integers, 'M,' and 'N.'
 *Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. 
 *Continue the same until the end of the linked list.
  To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.
  
  Input : 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null
          M = 2, N = 2
          
  Output : 1 -> 2 -> 5 -> 6 -> null
 * */
package linkedList2_assigment;

import java.util.Scanner;

import linkedList1.Node;

public class DeleteEveryNnodes {

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		
		head = skipMdeleteN(head, 2, 3);
		
		printLinkedList(head);

	}
	// Watch the hint video to understand the approach.
	public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
		if(head == null){
            return head;
        }else if(M == 0){
            return null;
        }else if(N == 0){
            return head;
        }
        
		Node<Integer> t1 = head;
        Node<Integer> t2 = null;
        
        while(t1 != null){
            
            for(int i=1; i<M && t1 != null; i++){
                t1 = t1.next;
            }
            
            if(t1 == null){
                break;
            }
            
            t2 = t1.next;
            for(int j=1; j<N && t2 != null; j++){
                t2 = t2.next;
            }
            
            if(t2 != null){
                t2 = t2.next;
            }
            
            t1.next = t2;
            t1 = t2;
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
