package ocajp;

public class Operator3 {

    public static void main(String args[]) {

        test1();
        test2();
    }

    private static void test1() {
        boolean b1 = false;
        boolean b2 = false;
        //if (b2 != b1 = !b2) {
        if (b2 != (b1 = !b2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    /*
    
     Note that boolean operators have more precedence than =. (In fact, = has least
     precedence of all operators.)
    
     so, in (b2 != b1 = !b2) first b2 != b1 is evaluated which returns a value 'false'. So the
     expression becomes false = !b2. And this is illegal because false is a value and not a
     variable!
     
     Had it been something like (b2 = b1 != b2) then it is valid because it will boil down to
     : b2 = false.
    
     Because all an if() needs is a boolean, now b1 != b2 returns false which is a boolean
     and as b2 = false is an expression and every expression has a return value (which is
     actually the Left Hand Side of the expression). Here, it returns false, which is again a
     boolean.
     Note that return value of expression : i = 10 , where i is an int, is 10 (an int).
     */
    private static void test2() {
        byte b = 1;
        char c = 1;
        short s = 1;
        int i = 1;

        //s = b * b;    no compile returns an int
        i = b << b;     // Dont know.
        s <<= b;        //All compound assignment operators internally do an explicit cast.
        //c = c + b;    no compile returns an int
        s += i;         //All compound assignment operators internally do an explicit cast.

    }
    /*
     Remember these rules for primitive types:
    
     1. Anything bigger than an int can NEVER be assigned to an int or anything smaller
     than int ( byte, char, or short) without explicit cast.
     
     2. CONSTANT values up to int can be assigned (without cast) to variables of lesser
     size ( for example, short to byte) if the value is representable by the variable.( that is,
     if it fits into the size of the variable).
    
     3. operands of mathematical operators are ALWAYS promoted to AT LEAST int. (i.e.
     for byte * byte both bytes will be first promoted to int.) and the return value will be
     AT LEAST int.
    
     4. Compound assignment operators ( +=, *= etc) have strange ways so read this
     carefully:
     */
}
