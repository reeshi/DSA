package linkedList2;

import java.util.LinkedList;

public class CollectionsLinkedList {

	public static void main(String[] args) {
		
		LinkedList<Integer> ll = new LinkedList<>();
		
		// add element at the last of the list
		ll.add(10);
		ll.add(20);
		ll.add(30);
		// add at specific index
		ll.add(0, 100);
		// add at first
		ll.addFirst(80);
		// set the element at specific index , it will replace the value
		ll.set(0, 60);
		// get the element at specific index
		ll.get(1);
		
		// travel 
		for(int i=0; i<ll.size(); i++) {
			System.out.println(ll.get(i));
		}
	}

}
