package ocpjp;

import java.util.*;

public class MapBasics {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
		

	private static void test1() {

		HashMap<Integer, String> hMap = new HashMap<>();
		
		Hashtable<Integer, String> htab = new Hashtable<>();
		
		hMap.put(1, "1");
		hMap.put(null, "2"); // one null key allowed in hashmap
		
		for(Integer key: hMap.keySet()) {
			System.out.println(key);  // null 1 order is not predictable.
			/*
			 * Exception in thread "main" java.util.ConcurrentModificationException
			 * Fail-safe is relevant from the context of iterators. If an iterator has been created on a collection object 
			 * and some other thread tries to modify the collection object "structurally?, a concurrent modification exception will be thrown. 
			 * It is possible for other threads though to invoke "set" method since it doesn?t modify the collection "structurally?. 
			 * However, if prior to calling "set", the collection has been modified structurally, "IllegalArgumentException" will be thrown.
			 */
			// hMap.put(3,"3");
		}
		
		htab.put(1, "1");
		// Runtime exception Exception in thread "main" java.lang.NullPointerException. Null not allowed in hashtable.
		// htab.put(null, "2");
	}
	
	private static void test2() {
		TreeMap tree = new TreeMap();
		tree.put("aa", 1);
		tree.put("cc", 2);
		tree.put("ee", 3);
		tree.put("gg", 4);
		NavigableMap nvMap = tree.headMap("ee", false); // false mean 'ee' key not included.
		// Exception in thread "main" java.lang.IllegalArgumentException: key out of range
		// nvMap.put("nn", 5); 
		nvMap.put("cc", 8); // Possible, to update in NavigableMap. Adding new key throws exception.
		System.out.println(nvMap); // {aa=1, cc=8}
		
	}
	
	private static void test3() {
		String[] arr = { "java", "champ", "champion" };
		System.out.println(Arrays.binarySearch(arr, "champion")); // result is unpredictable as array is not sorted. ***
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr)); //[champ, champion, java]
		System.out.println(Arrays.binarySearch(arr, "champion")); // 1
		
		System.out.println(Arrays.binarySearch(arr, "dou")); // -3 means evaluated with (-(insertion point) - 1)  (-(-3) -1) = 2. 
	}
	
	private static void test4() {
		TreeMap<Integer,String> map  = new TreeMap<Integer,String>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		
		//tailMap: returns a view of the portion of this map whose keys are greater than (or equal to, if is true) to the given key.
		SortedMap<Integer, String> smap1 = map.tailMap(2); 
		System.out.println(smap1);  // {2=two, 3=three, 4=four}
		
		// headMap: returns a view of the portion of this map whose keys are less than (or equal to, if is true) to the given key.
		SortedMap<Integer, String> smap2 = smap1.headMap(4);
		System.out.println(smap2); // {2=two, 3=three}
		
		//subMap: returns a view of the portion of this map whose keys range from to (where to value is exclusive).
		SortedMap<Integer, String> smap3 = smap2.subMap(2, 3);
		System.out.println(smap3); // {2=two}
		
	}
}
