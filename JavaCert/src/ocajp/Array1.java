package ocajp;

public class Array1 {

    public static void main(String... args) {

        int a[] = {1, 2};

        System.out.println(a.getClass().getName());

        Object[] obj = new Integer[]{1, 2, 3};

        // Not allowed
        // 1. You cannot specify the length of the array if you are using the initializer block while declaring the array.
        // 2. Size of the array is NEVER specified on the Left Hand Side. You cannot specify the size on left hand side .
        //    mean no 'int[4] arr' or 'int arr[4]'
        //Object[3] obj = new Integer[]{1, 2, 3};
        //Object obj[3] = new Integer[]{1, 2, 3};
        //Object obj[] = new Integer[3]{1, 2, 3};
    }
}

/*

Note1: There is a subtle difference between: int[] i; and int i[]; although in both the cases, i is an array of integers.

The difference is if you declare multiple variables in the same statement such as:

int[] i, j; and int i[], j;, j is not of the same type in the two cases.
In the first case, j is an array of integers while in the second case, j is just an integer.

________________________________________________________________________________________________________________________

Note2: The statement iA[i] = i = 30 ; will be processed as follows:

iA[i] = i = 30; => iA[0] = i = 30 ; => i = 30; iA[0] = i ; => iA[0] = 30 ;

Here is what JLS says on this:

1 Evaluate Left-Hand Operand First
2 Evaluate Operands before Operation
3 Evaluation Respects Parentheses and Precedence
4 Argument Lists are Evaluated Left-to-Right

For Arrays: First, the dimension expressions are evaluated, left-to-right. If any of the
expression evaluations completes abruptly, the expressions to the right of it are not
evaluated.
______________________________________________________________________________________________________________________

Note3: sublist(1 , 1) will return an empty list.

_______________________________________________________________________________________________________________________

*/
