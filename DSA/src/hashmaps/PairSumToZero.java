/*Given a random integer array A of size N.
 *Find and print the count of pair of elements in the array which sum up to 0.
 *Note: Array A can contain duplicate elements as well.
 * */
package hashmaps;

import java.util.HashMap;

public class PairSumToZero {

	public static void main(String[] args) {

		int[] arr = {2,2,2,-2,-2,-2};

		System.out.println(PairSum(arr, arr.length));

	}

    public static int PairSum(int[] input, int size) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
		for(int i = 0; i<size; i++){
			
            int rem = 0 - input[i];
            
            if(map.containsKey(rem)){
                int frequency = map.get(rem);
                for(int j=0; j<frequency; j++){
                    count++;
                }
            }
            
            if(map.containsKey(input[i])){
                map.put(input[i], map.get(input[i]) + 1);
            }else{
                map.put(input[i], 1);
            }
            
        }
        
        return count;
    }

}
