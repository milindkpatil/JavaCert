package ocajp;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Constructor1 {

    long l1;

    /** 
     * This is other question::
     
     You can call only public and protected constructors of the super class from a subclass
     if the subclass is not in the same package because only those are inherited.
     
     False because : 
     
     Most of the statement is correct but remember that constructors are NEVER (whether
     public or otherwise) inherited. (The above statement is true for other methods though.)
     
     * This is other question::
      
      A constructor cannot be final, static or abstract.
      
     */
        
    // But it becomes a valid method if you give a return type.
    public void Constructor1(long pLong) {
        l1 = pLong;
    } //(1)

    public static void main(String args[]) {
        Constructor1 a, b;
        
        //The class has an implicit default constructor since the class doesn't have any constructor defined.
        a = new Constructor1(); //(2)
        
        // This will give error as no valid constructor
        // b = new Constructor1(5); //(3)
    }
}


class BaseCon {

       public BaseCon() throws IOException {
       }
}

class Con1 extends BaseCon {
    public Con1() throws IOException {   
    }
}

class Con2 extends BaseCon {
    public Con2() throws Exception, FileNotFoundException {   
    }
    
    //public Con2() throws FileNotFoundException {   
    //} Will not compile
}

class Con3 extends BaseCon {
    public Con3() throws IOException, ArrayIndexOutOfBoundsException, RuntimeException {   
    }
}


/*
 # Remember: Constructor must declare all the checked exceptions declared in the base constructor (or the super classes of the checked exceptions). They may add other
   exception. This behavior is exactly opposite from that of methods. The overriding method cannot throw any exception other than overridden method. It may throw
   subclasses of those exceptions.

 # NOTE: Above rule make sense because base class constructor call super class constructor by defualt super() if not mentioned explicit call of super(..).
*/