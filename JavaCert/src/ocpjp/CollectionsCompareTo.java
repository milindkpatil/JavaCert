package ocpjp;

public class CollectionsCompareTo {

	public static void main(String[] args) {
		
	}
}

class Foo implements Comparable<Foo> {
	String code;
	Foo(String c) {
		code = c;
	}
	/*
	int compareTo(Foo f) {
		return this.code.compareTo(f.code);
	}*/
	
	public int compareTo(Foo f) {
		return this.code.compareTo(f.code);
	}
}
/*
In class Foo when overriding method compareTo() we must keep the access specifier "public" since the overriding rules say: 
the access specifier for an overriding method can allow more, but not less, access than the overridden method
*/