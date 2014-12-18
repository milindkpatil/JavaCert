/*
 # an overriding method can be made less restrictive. protected is less restrictive than 'default' access

 # an overriding method can change the return type of the overridden method to a subclass of the original return type not the super class object.

 # A class cannot override the super class's constructor. Because constructors are not inherited.

 # Covariant returns are allowed since Java 1.5, which means that an overriding method can change the return type to a subclass (not superclass) 
 of the return type declared in the overridden method. But remember than covarient returns does not apply to primitives.

 # If original (overridden) method does not have any throws clause, the overriding method cannot declare any checked exceptions

 # For non abstract original (overridden) method, you can make corresponding overriding method abstract!! You would have to make the class as abstract as well though.

 # You can either call super(...) or this(...) but not both.

 # No exception (i.e. an empty set of exceptions) is a valid subset of the set of exceptions thrown by the original method so an overriding method can choose to
   not have any throws clause (because emty set is also subset).

 # Remember: Constructor must declare all the checked exceptions declared in the base constructor (or the super classes of the checked exceptions). They may add other
   exception. This behavior is exactly opposite from that of methods. The overriding method cannot throw any exception other than overridden method. It may throw
   subclasses of those exceptions.

 # An overriding method cannot exhibit behavior that contradicts the declaration of the original method. An overriding method therefore cannot return a different type 
 (except a subtype) or throw a wider spectrum of exceptions than the original method in the superclass. (only subset is allowed, narrow down the exception using subclass of exception).

 # static method cannot be overridden by a non-static method and vice versa. IT is not exactly overridden but same signature not allowed. However, you can this is allowed in 
 instance and static varible. You can define same variable name in subclass as that of static variable in super class and vice versa.

 # static block in class only initiated when object of class is created, mere declaring variable of that class with null will not initiate static block.

 #

 */
package ocajp;

class Teacher {

    void teach(String student) {
        /* lots of code */
    }
}

class Prof extends Teacher {

    // It overloads the teach() method instead of overriding it.
    public void teach() throws Exception {

    }

    // It overloads the teach() method instead of overriding it.
    private void teach(int i) throws Exception {

    }

    // This overrides Teacher's teach method. The overriding method can have more
    // visibility. (It cannot have less. Here, it cannot be private.)
    /*
    
     THIS IS POSSIBLE
    
     protected void teach(String s){
        
     }
    
     */
    // Overriding method may be made final.
    public final void teach(String s) {

    }

    /*
    
     This is wrong because class Prof has not been declared as abstract. Note that
     otherwise it is OK to override a method by an abstract method.
    
     THIS NOT POSSIBLE.
    
     public abstract void teach(String s) {
    
     }
    
     */
}
