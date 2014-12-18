package ocajp;

public class Operator1 {

    public static void main(String args[]) {

        System.out.println(1 + 2 + "3");  // 33

        System.out.println("1" + 2 + 3); // 123

        System.out.println(4 + 1.0f); // 5.0

        System.out.println(5 / 4); // 1

        System.out.println('a' + 1); // 98 ... promoted to int 97 + 1 

        System.out.println(7.5 % 5.0);  // 2.5 as a remember % works with double.

        int k = 1;
        k += 3 + ++k;
        System.out.println(k); // It will print 6
        /*
         Expand the += operator as:
         k = k + 3 + ++k;
         
         This becomes (remember that k = 1 at this point):
        
         k = 1 + 3 + (++k) i.e.
         k = 1 + 3 + 2; (at this point value of k is 2 because of ++k). But the value of Right
         Hand Side has not yet been assigned to k.
         
         k = 6; 6 is assigned to k thereby overwriting the value of 2.
         Therefore, the final value of k is 6.
        
         */
    }

}
