package ocajp;

import java.*; //1

public abstract class Basic1 //2
{

    /*
     Although it does not make sense to make static variable transient as static variables
     are not serialized anyway, it is valid to do so.
    
     You can apply all the modifiers to member variables except abstract, native and synchronized.
     For methods, you cannot apply transient and volatile.
    
     */
    private static final transient int i = 20;

    // Valid main method
    final public static void main(String[] array) {

    }

   // float density = 20.0; //3
    public class Doer //4
    {

        //  void do() //5
        {

        }
    }
}

/*

    // 3 20.0 is a double and needs a cast to be assigned to a float.

    // 5 do is a keyword so do() is not a valid method name.

*/
