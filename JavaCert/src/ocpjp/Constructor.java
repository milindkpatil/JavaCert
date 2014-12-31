package ocpjp;

public class Constructor {
	
	
	public Constructor() { 	}
	
	protected Constructor(int i) { 	}
	
	Constructor(short s) { 	}
	
	private Constructor(float f) { 	}
	
	//final ConstructorBasics(long l) { 	}
	
	//abstract ConstructorBasics(long l) { 	}
	
	//static ConstructorBasics(long l) { 	}
	
	
	/* 
	 * Above three modifier final, abstarct and static are not valid for constructor as
	  
	 When you set a method as final, it means : "You don't want any class override it", but constructor by JLS definition can't overridden,so it is clean.
	 
	 When you set a method as 'abstract',it means:"Method don't have any body and you want to implement it at another time in a child class", 
	 but the constructor is called implicitly when the new keyword is used so it can't lack a body.
	 
	 When you set a method as 'static', it means: "Method belong to class, not a particular object" 
	 but constructor implicitly called to initialize an object, so there is no purpose in having a static constructor.
	 * 
	 */

	public static void main(String[] args) {
		Constructor cb = new Constructor(5f);
	}
}


class SubCBS extends Constructor {
	public SubCBS(){
		try {
			// super();  Calling super() should be the first statement in the constructor not even try is allowed. **
		} finally {}
	}
}