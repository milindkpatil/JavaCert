package ocajp;

interface Rideable {

    String getGait();
}

public class Interface1 implements Rideable {

    int weight = 2;

    public static void main(String[] args) {
        new Interface1().go(8);
    }

    void go(int speed) {
        ++speed;
        weight++;
        int walkrate = speed * weight;
        System.out.print(walkrate + getGait());
    }

    /*
     This is error as all functions in interfaces are public.
     It has to be because it is interface.
     String getGait() {
     return " mph, lope";
     }
     */
    @Override
    public String getGait() {
        return "";
    }
}
