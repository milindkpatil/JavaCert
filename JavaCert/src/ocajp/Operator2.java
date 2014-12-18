package ocajp;

public class Operator2 {

    public static void main(String args[]) {

        // switch(8); will never compile switch needs body
        switch (8) {

        } // OKS

        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        int k = 9, s = 5;
        switch (k) {
            default:
                if (k == 9) {
                    s = s * 2;
                    break;
                } else {
                    s = s + 4;
                    break;
                }
            case 7:
                s = s + 3;
        }
        System.out.println(s);
    }
    // 9 as break will exit swith stmt even it is in else.
    // break is not applied to if only to switch and loops.

    private static void test2() {
        Integer i1 = 1;
        Integer i2 = new Integer(1);
        int i3 = 1;
        Byte b1 = 1;
        Long g1 = 1L;

        System.out.println(i1 == i2); // false different object 
        System.out.println(i1 == i3); // true This will return true because one operand is a primitive int, so the other will be
        //unboxed and then the value will be compared
        //System.out.println(i1 == b1); Will not compile
        System.out.println(i1.equals(i1)); //true same object same value.
        System.out.println(i1.equals(g1)); //false
        System.out.println(i1.equals(b1)); // false
        /*
         This will return false because they are pointing to objects of different types.
         Signature of equals method is : boolean equals(Object o);
         Thus, it can take any object as a parameter and so there will be no compilation
         error.
         Further, The equals method of all wrapper classes first checks if the two object
         are of same class or not. If not, they immediately return false.
         */
    }

    private static void test3() {
        String s = "hello";
        //if (s instanceof java.util.Date) {
        //    {
        //    }
        //}
        /*
         It will not even compile because the compiler knows that 's' (which is declared as of
         class String) can NEVER refer to an object of class java.util.Date. So, it will not
         accept this code.
         Had 's' been declared as a variable of type Object, this code would have compiled
         because compiler sees that at run time it is possible for s to refer to an object of class
         Date.
         */

    }

    private static void test4() {
        int i = 10;
        // System.out.println( i<20 ? out1() : out2() ); not compiled
    }

    /*
     Note that it is not permitted for either the second or the third operand expression of the
     ? operator to be an invocation of a void method.
    
     If one of the operands is of type byte and the other is of type short, then the type of
     the conditional expression is short.
     
     If one of the operands is of type T where T is byte, short, or char, and the other
     operand is a constant expression of type int whose value is representable in type T,
     then the type of the conditional expression is T.
     Otherwise, binary numeric promotion (5.6.2) is applied to the operand types, and the
     type of the conditional expression is the promoted type of the second and third
     operands.
     
     If one of the second and third operands is of the null type and the type of the other is
     a reference type, then the type of the conditional expression is that reference type.
    
     If the second and third operands are of different reference types, then it must be
     possible to convert one of the types to the other type (call this latter type T) by
     assignment conversion (5.2); the type of the conditional expression is T. It is a
     compile-time error if neither type is assignment compatible with the other type.
    
     */
    private static void out1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void out2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
