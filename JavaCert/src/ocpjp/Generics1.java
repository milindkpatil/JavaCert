package ocpjp;

import java.util.ArrayList;
import java.util.List;

/*
Generic Type Naming Convention
	Naming convention helps us understanding code easily and having a naming convention is one of the best practices of java programming language. 
	So generics also comes with it’s own naming conventions. Usually type parameter names are single, uppercase letters to make it easily distinguishable 
	from java variables.
	
	The most commonly used type parameter names are:
	
	E – Element (used extensively by the Java Collections Framework, for example ArrayList, Set etc.)
	K – Key (Used in Map)
	N – Number
	T – Type
	V – Value (Used in Map)
	S,U,V etc. – 2nd, 3rd, 4th types
*/
public class Generics1 {

	public static void main(String[] args) {		
		test1();
		test2();
		test3();
	}

	private static void test1(){
		List<String> list1 = new ArrayList<String>();
		/* Compile timer error as follow:
		  
		   Type mismatch: cannot convert from List<String> to List<Object>
		   
		List<Object> list2 = list1;
		*/		
	}
	
	private static void test2(){
		List<Gum> list1 = new ArrayList<Gum>();
		list1.add(new Gum());
		// Warning: List is a raw type. References to generic type List<E> should be parameterized
		List list2 = list1;
		// Warning: Type safety: The method add(Object) belongs to the raw type List. References to generic type List<E> should be parameterized
		list2.add(new Integer(9));
		System.out.println(list2.size());  // It prints 2 but test is having two warnings.		
	}
	
	private static void test3() {
		// Warning: List is a raw type. References to generic type List<E> should be parameterized
		List list1 = new ArrayList<Chewable>();// line 1
		// Warning: Type safety: The method add(Object) belongs to the raw type List. References to generic type List<E> should be parameterized
		list1.add(new Gum());// line 2
		// Warning: Type safety: The method add(Object) belongs to the raw type List. References to generic type List<E> should be parameterized
		list1.add(new Meat());// line 3
		// Warning: Type safety: The method add(Object) belongs to the raw type List. References to generic type List<E> should be parameterized
		list1.add(new Integer(9));// line 4
		System.out.println(list1.size());// line 5  // It prints 5 
	}	
}

interface Chewable {}
class Gum implements Chewable {}
class Meat implements Chewable {}