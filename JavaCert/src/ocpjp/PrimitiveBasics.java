package ocpjp;


// Works even if it is abstract as we are not creating instance of it
// without public also it will run. protected and private not allowed. Final or abstract allowed but not both.
abstract class PrimitiveBasics {

	public static void main(String[] args) {
		byte pByte = 10;
		
		// Compiler error: Type mismatch: Cannot convert from int to byte 
		//pByte = pByte + 10;
		// Following expression allowed as += internally do casting.
		pByte += 1000;
		
		System.out.println(pByte); // output -14 , left most bytes are ignored.

		callValue(pByte, pByte, pByte); // output Higher preference to byte...
		
		callValue(new byte[]{12,23,23}); // output Less preference to int, int, int
		
		callValue(pByte, pByte); // output Less preference to int, int, int
		
		// Compile Error: he method callLongValue(Long) in the type PrimitiveBasics is not applicable for the arguments (byte)-must be widen then box.
		// callLongValue(pByte);
		// Compile Error: The method callIntValue(Integer) in the type PrimitiveBasics is not applicable for the arguments (byte)
		// callIntValue(pByte);
	}
	
	public static void callValue(int i, int j, int k){
		System.out.println("Higher preference to byte...");
	}
	
	public static void callValue(byte... b) {
		System.out.println("Less preference to int, int, int");
	}
	
	public static void callLongValue(Long longVal){ }
	
	public static void callIntValue(Integer intVal){ }
}

/*
	Above code demonstrates the concept of Primitive Widening. Compiler use widening of byte to int and call method with int argument. 
	For Example, if you pass short value to a method but method with short argument is not available then compiler choose method with int argument. 
	Hence output produced of above code is "int value". Please note that we are not passing array to callValue method, 
	so the callValue(byte... b) will not be called. We are passing 3 parameters and it will choose method with exactly 3 parameters for widening.  
 */
