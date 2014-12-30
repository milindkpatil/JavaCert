package ocpjp;

public class AutoBoxBasics {
	
	public static void main(String[] args) {
		// Allowed autoboxing
		int primaryInt = new Integer(10);
		Integer objInt = 10;
		Integer objInt2 = 10;

		if (objInt.equals(primaryInt))
			System.out.println("Works."); // output Works.

		if (objInt == primaryInt)
			System.out.println("It Works."); // output It Works.

		if (objInt == objInt2)
			System.out.println("It Works."); // output It Works. Till 127 JVM reuses the objects.

		Integer objIntLarge1 = 128;
		Integer objIntLarge2 = 128;

		if (objIntLarge1 == objIntLarge2)
			System.out.println("It Works..."); // No output. Till 127 JVM reuses the objects.

		Float float1 = new Float(12);
		Float float2 = new Float(12);
		// Compile timer error need cast
		// Float float2 = 128;

		if (float1 == float2)
			System.out.println("It Works..."); // No output. Floats are not	cached.
		
		calculate(451); // In double overloaded:451.0. See explanation below.

		Integer in = new Integer(null); // Exception in thread "main" java.lang.NumberFormatException: null. It gets compiled.
	}

	public static void calculate(double no1) {
		System.out.println(" In double overloaded:" + no1);
	}

	public static void calculate(Integer num) {
		System.out.println(" In Integer overloaded: " + num);
	}
}
/*

Widening of a primitive is more desirable than performing an autoboxing.Primitive widening uses the "smallest" method argument possible.
You CANNOT widen from one wrapper type to another.
Widening beats boxing and var-args.Hence primitive widening from int to double is more desirable than int to Integer.

*/