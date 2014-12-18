package ocajp;

public class Array2 {

    static int[] x = new int[0];

    static {
        x[0] = 10;
    }

    public static void main(String[] args) {
        Array2 ax = new Array2();
    }
}

/*
Explanation:

Even though the line x[0] = 10; will throw

java.lang.ArrayIndexOutOfBoundsException, JVM will wrap it and rethrow
java.lang.ExceptionInInitializerError.

The following is the output when the program is run:

java.lang.ExceptionInInitializerError
Caused by: java.lang.ArrayIndexOutOfBoundsException: 0
    at AX.<clinit>(SM.java:6)

Exception in thread "main"
Java Result: 1

*/