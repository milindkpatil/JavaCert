package ocpjp;

import java.io.IOException;

class AirPlane {
	public AirPlane() throws IOException, RuntimeException {
		System.out.println("AirPlane");
	}
}

// class AirJet extends AirPlane { }

// Compile error: AirJet must declare a constructor that throws IOException or
// any of its supertypes

// --------------------------------------------------------------------------------------------------------------------------------

interface Foldable {
	public void fold() throws Exception;
}

class Paper implements Foldable {
	public void fold() {
		System.out.print("Fold");
	}
}

public class Exceptions {
	public static void main(String args[]) {
		test1();
		test2();
	}

	private static void test2() {
		String stmt = "javachamp 2009";
		String[] arr = stmt.split(" ");
		try {
			int x = Integer.parseInt(arr[1]);  // Throws runtime exception NumberFormatException hence no need to catch.
			System.out.print(x);
			
			System.out.print(-10.0 / 0);  // -Infinity output
		} finally {
			System.out.print("finally");
		}
	}

	private static void test1() {

		Foldable obj1 = new Paper();
		// obj1.fold(); // Compilation error, unhandled exception. During compile time it checks the signature from Foldable rather than Paper.
		Paper obj2 = new Paper();
		obj2.fold();
	}

}

// Output : Fold2009-Infinityfinally