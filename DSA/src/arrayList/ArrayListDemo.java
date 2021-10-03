package arrayList;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<>();
		// add element at last
		arr.add(10);
		arr.add(20);
		arr.add(30);
		
		// print arrayList using normal for loop
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
		// print arrayList using for - each loop
		for(int i: arr) {
			System.out.println(i);
		}
		
		// adding element at specific index
		arr.add(1, 80);
		
		// remove element at specific index
		arr.remove(1);
		
		// print size of arrayList
		System.out.println(arr.size());

	}

}
