package ocpjp;

import java.util.*;

public class SetBasics {

	public static void main(String[] args) {
		test1();
		test2();
	}
	
	private static void test1() {
		Collection c = null;
		////Exception in thread "main" java.lang.NullPointerException
		//Set s = new HashSet(c); 
	}
	
	private static void test2() {
		TreeSet<Integer> map  = new TreeSet<Integer>();
		map.add(1);
		map.add(2);
		map.add(4);
		map.add(7);
		// subSet: returns a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive
		SortedSet<Integer> smap = map.subSet(2,7);
		
		System.out.println(smap); // [2,4]
		
		map.add(5);
		map.add(9);
		System.out.println(smap); // [2,4,5] 
	}

}
// The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased. 0.75 is default.