package ocajp;

class XXX {

    public void m() throws Exception {
        throw new Exception();
    }
}

class YYY extends XXX {

    public
            void m() {
    }
}

public class Overriding2 {

    public static void main(String[] args) {

        /*
        
         ______ obj = new ______();
         obj.m();
        
         */
    }
}

/*

Explanation:

1. The overriding method may choose to have no throws clause even if the overridden
method has a throws clause.

2. Whether a call needs to be wrapped in a try/catch or whether the enclosing method
requires a throws clause depends on the class of the reference and not the class of the
actual object.

Here, if you define s of type XXX, the call s.m() will have to be wrapped into a
try/catch because main() doesn't have a throws clause. But if you define s of class
YYY, there is no need of try catch because YYY's m() does not throw an exception.
Now, if the class of s is YYY, you cannot assign it an object of class XXX because
XXX is a superclass of YYY. So the only option is to do:

YYY s = new YYY();

*/
