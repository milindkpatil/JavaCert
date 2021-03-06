package ocpjp;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumBasics {

	enum WeekDays {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY // ***; is optional if there is no code.
	}
	
	enum SemiDemo implements Runnable{ // extends Thread{  Enum can not extends any class. It can implement interface. Enum can not be abstract.
		SEMI_IS_NOT_OPTIONAL(7); // *** ; is NOT optional here.
		SemiDemo(int i) { 	}

		@Override
		public void run() {		}
	}

	public static void main(String[] args) {
		//Can not declare enum inside any method.
		// enum CoffeeSize{ SMALL, NORMAL, BIG ; } 
		
		SemiDemo k = SemiDemo.SEMI_IS_NOT_OPTIONAL;
		System.out.println(k); // Output SEMI_IS_NOT_OPTIONAL
		
		int[] arrayvalues = { 12, 34, 56, 23, 5, 13, 78 };

		Map<WeekDays, Integer> daymap = new HashMap<>();
		for (WeekDays day : WeekDays.values()) {
			daymap.put(day, arrayvalues[day.ordinal()]);
		}

		EnumMap<WeekDays, Integer> enumap = new EnumMap<>(daymap);

		/*
		 * It is exception 
		 * NullPointerException at enumap.put(null, 100);The null reference as a key is not allowed in EnumMap.		
		 **/
		// enumap.put(null, 100);
		System.out.println("Frequency EnumMap: " + enumap);
		// Output : Frequency EnumMap: {MONDAY=12, TUESDAY=34, WEDNESDAY=56, THURSDAY=23, FRIDAY=5, SATURDAY=13, SUNDAY=78}
	}
	
	public void callMethod() {
		/*enum JavaExams {
			SCJP, SCWD, OCJP
		}*/// Not allowed compile time error. See explanation.
	}
}

/*
An enum declaration is a special kind of class declaration:
1) It can be declared at the top-level and as static enum declaration. 
2) It is implicitly static, i.e. no outer object is associated with an enum constant.
3) It is implicitly final unless it contains constant specific class bodies, but it can implement interfaces.
4) It cannot be declared abstract unless each abstract method is overridden in the constant-specific class body of every enum constant.
5) Local (inner) enum declaration is NOT OK! 

Here in public void callMethod() { enum JavaExams { SCJP, SCWD, OCJP } } enum declaration is local within method so compile time error.
 
*/