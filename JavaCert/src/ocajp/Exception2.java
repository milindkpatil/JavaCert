package ocajp;

public class Exception2 {

    public static void methodX() throws Exception {
        throw new AssertionError();
    }

    public static void main(String[] args) {
        try {
            methodX();
        } catch (Exception e) {
            System.out.println("EXCEPTION");
        }
    }
}

/*

 A subclass of Error cannot be caught using a catch block for Exception
 because java.lang.Error does not extend java.lang.Exception.

 It is true that assertions are disabled by default however, methodX is throwing
 an AssertionError explicitly like any other Throwable. Here, the assertion
 mechanism is not even used.

 */
