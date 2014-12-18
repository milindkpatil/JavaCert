package ocajp;

public class Constructor2 {}

class Base3 {

    int i;

    public Base3(int x) {
        this.i = x;
    }
}

class B extends Base3 {

    int j;

    public B(int x, int y) {
        super(x);
        this.j = y;
    }
    
    // Not allowed constructors are commented.
    //B( ) { }
    
    //B(int y ) { j = y; }
    
    //B(int y ) { i = y; j = y*2; }
    
    
    // Following constructor can be added safely without error.
    
    B(int y ) { super(y*2 ); j = y; }
    
    //B(int z ) { this(z, z); }
        
    /**
        To construct an instance of a sub class, its super class needs need to be constructed
        first. Since an instance can only be created via a constructor, some constructor of the
        super class has to be invoked.
        
        Either you explicitly call it or the compiler will add super() (i.e. no args
        constructor) as the first line of the sub class constructor.
        
        Now, if the super class ( here, A ) does not have a no args constructor, the call
        super() will fail. 
        
        * Hence, choices B( ) { }, B(int y ) { j = y; } and B(int
        y ) { i = y; j = y*2; } are not valid and choice B(int y ) { super(y*2 );
        j = y; } is valid because it explicitly calls super( int ) which is available in A.
        
        Instead of calling super(...) you can also call another constructor of the base
        class in the first line (as given in choice B(int z ) { this(z, z); } ). 
        
        Here, this(int, int) is called in the first line which in turn calls super(int). So the
        super class A is correctly instantiated.
     
     */
        
}
