/*

## Just to sure once again, Every field declaration in the body of an interface is implicitly public, static and
final. It is permitted, but strongly discouraged as a matter of style, to redundantly
specify any or all of these modifiers for such fields. A constant declaration in an
interface must not include any of the modifiers synchronized, transient or volatile, or a compile-time error occurs.

*/

package ocajp;

public class Overriding4 {

    public static void main(String args[]) {
        C1 c = new C1();

        //System.out.println (c.i); //2
        //System.out.println (c.j); //3
        System.out.println(c.k);
    }
}

class A1 {

    public int i = 10;
    private int j = 20;
}

class B1 extends A1 {

    private int i = 30; //1
    public int k = 40;
}

class C1 extends B1 {

}

/*

 You cannot access c.i because i is private in B. But you can access ( (A)c).i
 because i is public in A. Remember that member variables are shadowed and not
 overridden. So, B's i shadows A's i and since B's i is private, you can't access A's i
 unless you cast the reference to A.

 You cannot access c.j because j is private in A.

 */
