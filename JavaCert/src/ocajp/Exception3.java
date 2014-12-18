package ocajp;

public class Exception3 {

    public static void main(String[] args) {
        try {
            System.exit(0);
        } finally {
            System.out.println("finally is always executed!");
        }
    }
}

/*

 Explanation:

 'finally' is always executed (even if you throw an exception in try or catch) but this is
 the exception to the rule.

 When you call System.exit(...); The JVM exits so there is no way to execute the finally
 block.

 Explanation 2:

 While evaluating a[val()][i=1]++, when val() throws an exception, i=1 will not be executed.

 */
