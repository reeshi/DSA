/*You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively.
 *You need to print their intersection;
 *An intersection for this problem can be defined
 *when both the arrays/lists contain a particular value or to put it in other words,
 *when there is a common value that exists in both the arrays/lists.
 * */
package hashmaps;

import java.util.HashMap;

public class ArrayIntersection {

	public static void main(String[] args) {
		
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,2,3,4,6};
		
		intersection(arr1, arr2);

	}

	public static void intersection(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i=0; i<arr1.length; i++){
			if(map.containsKey(arr1[i])){
				int val = map.get(arr1[i]);
				++val;
				map.put(arr1[i], val);
			}else{
				map.put(arr1[i], 1);
			}
		}

		for(int i=0; i<arr2.length; i++){
			if(map.containsKey(arr2[i]) && map.get(arr2[i]) > 0){
				System.out.print(arr2[i] + " ");
				int val = map.get(arr2[i]);
				--val;
				map.put(arr2[i], val);
			}
		}

	}

}
