package ocpjp;

import java.util.ArrayList;
import java.util.List;

public class Generics4 {
	public static List<? extends Chewable> printSize(List<? extends Chewable> list) { // Line 10
		System.out.println(list.size());
		return list;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<? extends Chewable> list1 = new ArrayList<Meat>(); // Line 16
		List<Chewable> list2 = new ArrayList<Chewable>(); // Line 17
		List<Meat> list3 = new ArrayList<Meat>(); // Line 18
		
		list1 = printSize(list1); 
		// Compile Error: Type mismatch: cannot convert from List<capture#6-of ? extends Chewable> to List<Chewable>
		// Because, List<Chewable> can not hold ArrayList<Meat> , hence above conversion is denied.
		//list2 = printSize(list2); 
		// Compile Error: Type mismatch: cannot convert from List<capture#6-of ? extends Chewable> to List<Meat>
		// Because, List<Chewable> can not hold ArrayList<Meat> , hence above conversion is denied.
		//list3 = printSize(list3); 
		
		List<? extends Chewable> listx = new ArrayList<Meat>();
		List<? extends Chewable> listy = new ArrayList<Chewable>();
		
		// Compile Error: The method add(capture#6-of ? extends Chewable) in the type List<capture#6-of ? extends Chewable> 
		// is not applicable for the arguments (Meat)
		//list1.add(new Meat());
	}
}

/*
You can not add anything to collection which is declared using ?.This rule is only applicable for <? extends X>not for <? super X>.
Reason being is that in case of<? extends X> there is chances of add of wrong type object.
For example let you declare List<? extends Animal> l=new ArrayList<Dog>.Now this is right declaration but here you can also 
perform l.add(new cat()).cat being an object of animal class.which leads to exception in runtime.
Thats why addition through <? extends X> is prohibited.In case of<? super X> it allowed but we can add only subclass of X only and 
not its superclass object.

*/