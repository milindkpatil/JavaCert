/*
 ## Again static block in class only initiated when object of class is created, mere declaring variable of that class with null will not initiate static block.

*/
package ocajp;

class Super {

    static String ID = "QBANK";
}

class Sub extends Super {

    static {
        System.out.print("In Sub");
    }
}

public class Static1 {

    public static void main(String[] args) {
        System.out.println(Sub.ID);
    }
}

// Prints "QBANK" only.
