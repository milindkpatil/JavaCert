package ocpjp;

class A {
	void m() {
		System.out.println("outer");
	}
}

public class ICScope {
	public static void main(String[] args) {
		new ICScope().go();
	}

	void go() {
		new A().m();
		this.new A().m(); // is also valid call.
		
		class A {
			void m() {
				System.out.println("inner");
			}
		}
	}

	class A {
		void m() {
			System.out.println("middle");
			
			// Valid calls to go()
			// But will result in runtime StackOverflowError exception.
			ICScope.this.go();
			
			//Invalid calls to go()
			// this.ICScope.this.go();
		}
	}
}
/*
output: middle

The "inner" version of class A isn't used because its declaration comes
after the instance of class A is created in the go() method

*/