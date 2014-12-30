package ocpjp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Generics3 {

	public static void main(String[] args) {
		test1();
	}

	private static void test1(){
		List<Number> list = new ArrayList<>();
		list.add(new Byte((byte) 3));  // No int constructor
		list.add(new Short((short) 3)); // No int constructor
		list.add(new Byte("3"));  
		list.add(new Short("3"));
		list.add(new AtomicInteger(4));
		list.add(new AtomicLong(4));
		list.add(new BigDecimal(4));
		list.add(new BigInteger("5")); // No int constructor
		list.add(new Integer(3));
		list.add(new Integer(3));
		list.add(new Integer(3));
		list.add(new Double(4));
		
		// Compile Error: Type mismatch: cannot convert from ArrayList<Integer> to List<Number>
		// list = new ArrayList<Integer>();
	}
}
