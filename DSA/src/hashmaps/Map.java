package hashmaps;

import java.util.ArrayList;

public class Map<K, V> {
	
	private ArrayList<MapNode<K, V>> buckets;
	private int count; // count how many element present in the map.
	private int numBuckets;
	
	public Map() {
		buckets = new ArrayList<>();
		numBuckets = 5;
		for(int i=0; i<numBuckets; i++) {
			buckets.add(null);
		}
	}
	
	private int getBucketIndex(K key) {
		int hc = key.hashCode();
		int index = hc % numBuckets;
		return index;
	}
	
	//Insert function.
	public void insert(K key, V value) {
		
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		
		// key is already present then just update its value.
		while(head != null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		// key is not present then insert the node at 0th position in the linked list.
		head = buckets.get(bucketIndex);
		MapNode<K, V> newNode = new MapNode<>(key, value);
		newNode.next = head;
		buckets.set(bucketIndex, newNode);
		count++;
		
		double loadFactor = (1.0 * count) / numBuckets;
		if(loadFactor >= 0.7) {
			reHash();
		}
		
	}
	
	// Rehashing is done when load factor(no. of entries / buckets size) is greater than 0.7
	// Rehashing we increase the size of buckets
	private void reHash() {
		ArrayList<MapNode<K, V>> temp = buckets;
		buckets = new ArrayList<MapNode<K, V>>();
		
		for(int i=0; i<2*numBuckets; i++) {
			buckets.add(null);
		}
		
		count = 0;
		numBuckets = 2 * numBuckets;
		
		for(int i=0; i<temp.size(); i++) {
			MapNode<K, V> head = temp.get(i);
			while(head != null) {
				insert(head.key, head.value);
				head = head.next;
			}
		}
		
	}
	
	//it gives the load factor
	public double loadFactor() {
		return (1.0 * count)/numBuckets;
	}
	
	public int size() {
		return count;
	}
	
	// get value fucntion returns the value of key if key present else returns null.
	public V getValue(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		
		while(head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			
			head = head.next;
		}
		
		return null;
	}
	
	// remove key function removes the key and returns the value of removed key
	// if key is not present than return null
	public V removeKey(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> prev = null;
		
		while(head != null) {
			if(head.key.equals(key)) {
				V temp = head.value;
				
				if(prev != null) {
					prev.next = head.next;
				}else {
					buckets.set(bucketIndex, head.next);
				}
				
				return temp;
			}
			
			prev = head;
			head = head.next;
		}
		
		return null;
	}
}
