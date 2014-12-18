package ocajp;

class Base {

    void method1() throws java.io.IOException, NullPointerException {
        someMethod("arguments");
        // some I/O operations
    }

    int someMethod(String str) {
        if (str == null) {
            throw new NullPointerException();
        } else {
            return str.length();
        }
    }
}

public class Exception4 extends Base {

    @Override
    void method1() {
        someMethod("args");
    }
}

/*
Explanation:

Overriding method only needs to specify a subset of the list of exception classes the
overridden method can throw. A set of no classes is a valid subset of that list.

Remember that NullPointerException is a subclass of RuntimeException, while
IOException is a subclass of Exception.
*/
