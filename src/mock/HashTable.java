package mock;

import java.util.HashMap;
import java.util.Map;

public class HashTable<K, V> {
	
	
	public class Entry{
		K key;
		V val;
		
		Entry next;
		public Entry(K key, V val) {
			key = key;
			val = val;
		}
		
	}
	Entry[] buckets;
	int SIZE;
	public HashTable(int size) {
		SIZE = size;
	}
	
	V get(K key) {
		int id = key.hashCode() % SIZE;
		Entry currEntry = buckets[id];
		if(currEntry == null)
			return null;
		
		while(currEntry != null) {
			if(currEntry.key.equals(key)) {
				return currEntry.val;
			}
			currEntry = currEntry.next;
		}
		return null;
	}
	
	void put(K key, V value) {	
		int id = key.hashCode() % SIZE;
		Entry currEntry = buckets[id];
		if(currEntry == null) {
			currEntry.val = value;
			buckets[id] = currEntry;
			return;	
		}
		else {
			while(currEntry.next != null) {
				if(currEntry.key.equals(key)) {
					currEntry.val = value;
					return;
				}
				currEntry = currEntry.next;
			}
			if(currEntry.key.equals(key)) {
				currEntry.val = value;
				return;
			}
			else {
				currEntry.next = new Entry(key, value);
			}
		}
	}
	

	
	
	
	
	

}
