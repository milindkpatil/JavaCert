package ocpjp;

public class ICBasics {
	
	static private int sprix = 10;
	static int sdx = 100;
	static protected int sprox = 1000;
	static public int spubx = 10000;
	
	private int prix = 20;
	int dx = 200;
	protected int prox = 2000;
	public int pubx = 20000;

	private String pris = "private string";
	String ds = "default string";
	protected String pros = "public string";
	public String pubs = "public string";
	
	/*	Members modifiers allowed to inner class.
	 *  # final
		# abstract
		# public
		# private
		# protected
		# static—but static turns it into a static nested class not an inner class
		# strictfp
	 */	
	private class InnerClass {
		// The field {all below} cannot be declared static in a non-static inner type, unless initialized with a constant expression
		// static private int sprix = 10;
		// static int sdx = 100;
		// static protected int sprox = 1000;
		// static public int spubx = 10000;
		
		// static private int inner_sprix = 10;
		// static int inner_sdx = 100;
		// static protected int inner_sprox = 1000;
		// static public int inner_spubx = 10000;
		
		final static private int sprix = 30;
		final static int sdx = 300;
		final static protected int sprox = 3000;
		final static public int spubx = 30000;
		
		private int prix = 40;
		int dx = 400;
		protected int prox = 4000;
		public int pubx = 40000;
		
		private String pris = "inner private string";
		String ds = "inner default string";
		protected String pros = "inner public string";
		public String pubs = "inner public string";

		protected void innerTest(){
			System.out.println("default is " + prix); // refers to inner, if it is not present in inner class it will refer outer. ****
			System.out.println("Inner class ref is " + this.prix); // if it is not present in inner class this will be compile time error
			System.out.println("Outer class ref is " + ICBasics.this.prix); // if it is not preset in outer class this will be compile time error
			
			System.out.println("default static is " + sprix);
			System.out.println("Inner class static ref is " + this.sprix);
			System.out.println("Outer class sttaic ref is " + ICBasics.this.sprix);
			System.out.println("Inner class static ref is " + InnerClass.sprix);
			System.out.println("Outer class sttaic ref is " + ICBasics.sprix);
		}
	}
	
	// Allowed and behave similar to normal child class.
	public class InnerClass2 extends InnerClass {	}
	
	public Thread createThread(){
		
		final String finalMethodS = "Final method variable is accessible";
		String methodS = "Method variable not accessible in inner class of method";
		
		// Compile Error: InnerThread instance not found.
		// Thread t = new InnerThread();
		
		// Can't mark a method-local inner class public, private, protected, static, transient.
		// abstract and final is allowed.
		class MethodInnerThread extends Thread{

			// Variable scopes and access are same as InnerClass.
			public void run() {
				
				System.out.println("Inner thread speaking!!");
				System.out.println(finalMethodS);
				
				// Cannot refer to the non-final local variable methodS defined in an enclosing scope. Compiler error.
				// System.out.println(methodS);
			}
		}
		
		return new MethodInnerThread();
	}
	
	// Instance block
	{
		// Can't mark a instance-block-local inner class public, private, protected, static, transient.
		// abstract and final is allowed.
		// Quite similar to method-local-inner class.
		class InstanceBlockInnerThread extends Thread{

			// Variable scopes and access are same as InnerClass.
			public void run() {
				System.out.println("Instance Bloack Inner thread speaking!!");
			}
		}
		
		// Instantiation is only allowed below the definition.
		Thread ibit = new InstanceBlockInnerThread();
		ibit.start();
		try {
			ibit.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	// Static block (Similar will be the static method inner class).
	static {
		/* Can't mark a static-block-local inner class public, private, protected, static, transient.
		   abstract and final is allowed.
		   Remember that a local class declared in a static method has access
		   to only static members of the enclosing class, since there is no associated instance of the
		   enclosing class. If you're in a static method there is no this, so an inner class in a static
		   method is subject to the same restrictions as the static method. In other words, no access
		   to instance variables.
		*/
		class StaticBlockInnerThread extends Thread{

			// Can access all static variable of outer class.
			public void run() {
				System.out.println("Static Bloack Inner thread speaking!!");
			}
		}

		// Instantiation is only allowed below the definition.
		Thread sbit = new StaticBlockInnerThread();
		sbit.start();
		try {
			sbit.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * The class itself isn't really "static"; there's no such thing as a static class. The
	   static modifier in this case says that the nested class is a static member of the outer
	   class. That means it can be accessed, as with other static members, without having
	   an instance of the outer class.
	 */
	static public class StaticClass extends Thread{
		public void run(){
			System.out.println("Static class is not an inner class. :)");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ICBasics.InnerClass ic = new ICBasics().new InnerClass(); // Remember the syntax.
		ic.innerTest();
		ICBasics icb = new ICBasics();
		icb.createThread().start();
	
		Thread anonymousThread = new Thread() {
			public void run() {
				System.out.println("Anonymous class thread speaking!");
			}
		}; // This semicolon is mandatory.
		anonymousThread.start();
		
		anonymousThread.join();
		
		ICBasics.InnerClass anonymousIC = new ICBasics().new InnerClass(){
			public void innerTest(){
				
				System.out.println("Anonymoust IC is talking!");
				// Compiler Error: private super class field
				// System.out.println("default is " + prix);
				// System.out.println("Inner class ref is " + this.prix); 
				// Compiler Error: No enclosing instance of ICBasics is accessible in this scope.
				//System.out.println("Outer class ref is " + ICBasics.this.prix); 
				
				System.out.println("default static is " + sprix);
				// Compiler Error: private super class field
				// System.out.println("Inner class static ref is " + this.sprix);
				System.out.println("Outer class sttaic ref is " + ICBasics.this.sprix);
				System.out.println("Inner class static ref is " + InnerClass.sprix);
				System.out.println("Outer class sttaic ref is " + ICBasics.sprix);
				System.out.println("Anonymoust IC talking is done!");
			}
		}; // This semicolon is mandatory.
		
		anonymousIC.innerTest();	
		
		ICBasics.StaticClass sc = new ICBasics.StaticClass();
		sc.start();
	}
}