package ocajp;

import java.util.Collection;

class Loop1 {

    public static void main(String[] args) {
        int i = 20; //1

        /** Can not compile following 2 for loops
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " "); //2
        }
        for (int i = 10; i > 0; i--) {
            System.out.print(i + " "); //3
        } **/

        System.out.print(i + " "); //4
    }

    // 1. This is ok for instance not local variable.
    public static void test1() {
        Object o = null;
        Collection c = null; //valid collection object.
        int[][] ia = null;//valid array

        for (final Object o2 : c) {
        }
    }
    // 2. final is the only modifier (excluding annotations) that is allowed here.

    public static void test2() {

        int x;

        /** Unreachable code in while and for loop
        while (false) {
            x = 3;
        }

        for (int i = 0; false; i++) {
            x = 3;
        }
        **/

        if (false) {
            x = 3;
        }

    }
    /*
    
     while (false) { x=3; } is a compile-time error because the statement x=3; is not
     reachable;
    
     Similarly, for( int i = 0; false; i++) x = 3; is also a compile time error
     because x= 3 is unreachable.
    
     In if(false){ x=3; }, although the body of the condition is unreachable, this is not
     an error because the JLS explicitly defines this as an exception to the rule. It allows
     this construct to support optimizations through the conditional compilation. For
     example, 
    
     if(DEBUG){ System.out.println("beginning task 1"); }
    
    
     Here, the DEBUG variable can be set to false in the code while generating the
     production version of the class file, which will allow the compiler to optimize the
     code by removing the whole if statement entirely from the class file.
    
    
     */

    public static void test3() {

        for (;; Math.random()) {
            JILL:
            System.out.println("true");
            KILL:
            {
            }
        }

        /* For loop can't compile, see explaination
        for (;; Math.random() < 0.5) {
            System.out.println("true");
        }*/

    }

    /*
    
     Here, the first part (i.e. the init part) and the second part (i.e. the
     expression/condition part) part of the for loop are empty. Both are valid. (When
     the expression/condition part is emtpy, it is interpreted as true.)
         
     The third part (i.e. the update part) of the for loop does not allow every kind of
     statement. It allows only the following statements here: Assignment,
     PreIncrementExpression, PreDecrementExpression, PostIncrementExpression,
     PostDecrementExpression, MethodInvocation, and
     ClassInstanceCreationExpression. Thus, Math.random()<0.5 is not valid here,
     and so this will not compile.
        
    
     */
}
