// Remove duplicates elements from array.
package hashmaps;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,1,1,1};
		
		ArrayList<Integer> output = removeDuplicates(arr);
		System.out.println(output);
	}
	
	public static ArrayList<Integer> removeDuplicates(int[] arr){
		HashMap<Integer, Boolean> map = new HashMap<>();
		ArrayList<Integer> output = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				output.add(arr[i]);
				map.put(arr[i], true);
			}
		}
		
		return output;
	}

}
