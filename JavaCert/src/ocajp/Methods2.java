package ocajp;

public class Methods2 {
    
    int c;
    String x = this.toString();
    
    //private final double ANGLE; Will not compile see explaination
    
    public static void main(String[] args) {
        Methods2 n = new Methods2();
        
        System.out.println(n.c);  // prints 0
        System.out.println(n.x);  // prints "Magic"
    }
    
    @Override
    public String toString(){
        return "Magic";
    }
    
   // public void setAngle(double a){ ANGLE = a; } will not compile see explaination      
}

/*
The given code has two problems:
1. If you declare a field to be final, it must be explicitly initialized by the time the
creation of an object of the class is complete. So you can either initialize it immediately:
private final double ANGLE = 0;
or you can initialize it in the constructor or an instance block.

2. Since ANGLE is final, you can't change its value once it is set. Therefore the
setAngle method will also not compile.

*/