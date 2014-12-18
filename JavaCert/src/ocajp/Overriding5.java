package ocajp;

public class Overriding5 {
}

class A2 {

    public void perform_work() {
    }
}

class B2 extends A2 {

    public void perform_work() {
    }
}

class C2 extends B2 {

    public void perform_work() {
    }
}

// How can you let perform_work() method of A2 to be called from an instance method in C2?

// Not Possible

/*

The method in C2 needs to call a method in a superclass two levels up. But super is a
keyword and not an attribute so super.super.perform_work( ) strategy will not
work. There is no way to go more than one level up for methods.

Remember that this problem doesn't occur for instance variables because variable are
never overridden. They are shadowed. So to access any of the super class's variable,
you can unshadow it using a cast. For example, ((A2) c).data; This will give you the
data variable defined in A2 even if it is shadowed in B as well as in C2.

*/