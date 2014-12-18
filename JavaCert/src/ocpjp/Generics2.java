package ocpjp;

import java.util.ArrayList;
import java.util.List;

public class Generics2 {

	public static void main(String[] args) {
		test1();
		test2();
		//test3();
	}

	private static void test1(){
		// Allowed four statements about correct declaration and instantiation of list.
		List<String> list1 = new ArrayList<String>();
		List<?> list2 = new ArrayList<String>();
		List<? extends Object> list3 = new ArrayList<String>();
		// Warning: List is a raw type. References to generic type List<E> should be parameterized
		List list4 = new ArrayList<String>();
		
		System.out.println(" " + list1 + list2 + list3 + list4);
		
		// Compile Error : Type mismatch: cannot convert from ArrayList<String> to List<Object>
		// List<Object> list5 = new ArrayList<String>();
		// Compile Error : Cannot instantiate the type ArrayList<?>
		// List list6 = new ArrayList<?>();
	}
	/* test1 explanation:
	   Few rules about declaration and instantiation of generic type (NOT Complete LIST):
	 	1. ? cannot be used on the right hand side (instantiation).
		2. Type in declaration must match type in instantiation.
		3. When <?> is used as declaration type, any type can be used in instantiation.
		4. When <? extends X> as declaration type, X and any sub type of X can be used in instantiation.
	 */
	
	private static void test2(){
		List<? extends Chewable> list1 = new ArrayList<Meat>(); 
		List<Chewable> list2  = new ArrayList<Chewable>();
		
		// Compiler Error : Type mismatch: cannot convert from ArrayList<Meat> to List<? super Chewable>  
		// List<? super Chewable> list3 = new ArrayList<Meat>();
		
		Meat meat = new Meat();
		// Compile Error : The method add(capture#3-of ? extends Generics2.Chewable) in the type 
		// 				   List<capture#3-of ? extends Generics2.Chewable> is not applicable for the arguments (Generics2.Meat)
		// list1.add(meat); 
		list2.add(meat); 
	}	

}
