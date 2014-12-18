/*
 
## class main's main method will be executed. final is a valid modifier for the
 standard main method.

 Note that final means a method cannot be overridden. Although static methods
 can never be overridden. (they can be shadowed), making a static method final
 prevents the subclass from implementing the same static method.

## In A.java you can have 'class A ' without public modifier it is not compiler error.
 */
package ocajp;

class anothermain {

    public static void main(String[] args) {
        System.out.println("hello2");
    }
}

public class Main {

    public final static void main(String[] args) {
        System.out.println("hello");
    }
}
