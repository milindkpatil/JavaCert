package ocajp;

class A {

    A() {
        print();
    }

    void print() {
        System.out.println("A");
    }
}

public class Overriding3 extends A {

    int i = Math.round(3.5f);

    public static void main(String[] args) {
        A a = new Overriding3();
        a.print();
    }

    void print() {
        System.out.println(i);
    }
}

// It will print 0, 4

/*

Note that method print() is overridden in class Overriding3. Due to polymorphism, the method
to be executed is selected depending on the class of the actual object.

Here, when an object of class Overriding3 is created, first A's constructor is called, which in
turn calls print(). Now, since the class of actual object is Overriding3, Overriding3's print() is
selected. 

At this point of time, variable i has not been initialized (because we are still
initializing A at this point), so its default value i.e. 0 is printed.

This happens because the method print() is non-private, hence polymorphic.

*/
