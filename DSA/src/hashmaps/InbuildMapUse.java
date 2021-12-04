package hashmaps;

import java.util.HashMap;
import java.util.Set;

public class InbuildMapUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		
		// put the value in map
		// O(1).
		map.put("abc", 1);
		map.put("def", 2);
		map.put("reeshi", 13);
		
		// size
		// O(1).
		int size = map.size();
		System.out.println("Size : " + size);
		
		// check whether a key is present or not
		// if present return true else false 
		// O(1).
		if(map.containsKey("abc")) {
			System.out.println("Map has abc");
		}
		
		if(map.containsKey("abc1")) {
			System.out.println("Map has abc1");
		}
		
		// get the value of a particular key
		// if the given key is not present it will return null
		// so always check first that a particular key is present than acces it value.
		// get function is O(1).
		if(map.containsKey("abc")) {
			int val = map.get("abc");
			System.out.println(val);
		}
		
		// remove a key
		// if a key is not present it will not do anything.
		map.remove("def");
		
		// Iterate on hashmap
		// keyset function returns all the key of hashmap in set data structure.
		// keyset is O(N)
		Set<String> keys = map.keySet();
		for(String k: keys) {
			System.out.println(map.get(k));
		}
		
		
	}

}
