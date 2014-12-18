package ocajp;

class Feline {

    public String type = "f ";

    // super() will get call by default.
    // Understand the program initialization flow.
    public Feline() {
        System.out.print("feline ");
    }
}

public class Super1 extends Feline {

    public Super1() {
        System.out.print("cougar ");
    }

    public static void main(String[] args) {
        new Super1().go();
    }

    // Object reference 'this' and 'super' will refer to 'type' variable in Feline.
    void go() {
        type = "c ";
        System.out.print(this.type + super.type);
    }
}
