package ocajp;

class OverLoaded1 {

    void probe(int... x) {
        System.out.println("In ...");
    } //1

    void probe(Integer x) {
        System.out.println("In Integer");
    } //2

    void probe(long x) {
        System.out.println("In long");
    } //3

    void probe(Long x) {
        System.out.println("In LONG");
    } //4

    public static void main(String[] args) {
        Integer a = 4;
        new OverLoaded1().probe(a); //5
        int b = 4;
        new OverLoaded1().probe(b); //6
    }
}

/*

 To answer this type of questions, you need to know the following rules:

 1. The compiler always tries to choose the most specific method available with least
 number of modifications to the arguments.

 2. Java designers have decided that old code should work exactly as it used to work
 before boxing-unboxing functionality became available.

 3. Widening is preferred to boxing/unboxing (because of rule 2), which in turn, is
 preferred over var-args.

 */
// Following overloading is possible and Rule 1 is applied.
// Output: 3
class Varargs {

    public void test() {
        test1(10, 20); //1
    }

    public void test1(int i, int... j) {
        System.out.println("1");
    }

    public void test1(int... i) {
        System.out.println("2");
    }

    public void test1(int i, int j) {
        System.out.println("3");
    }

    public static void main(String[] args) {
        new Varargs().test();
    }
}
