package ocpjp;


// Final and stictfp is allowed at top level classes.
strictfp final public class StaticTest {
	static int p = test(); 
	
	static public int test() {
		System.out.println(p); // Output 0 as static variable is initialized to default value.
		return 99;
	}

	public static void main(String[] args) {
		System.out.println(p);  // Output 99  after test method executed
	}
}
