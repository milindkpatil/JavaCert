package ocajp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class List1 {

    public static void main(String[] args) {
        List p = new ArrayList();
        p.add(7);
        p.add(2);
        p.add(5);
        p.add(2);
        // Doesn't have sort method
        //p.sort();

        // You need to suplly compartor for sorting.
        /** following code will not compile no sort method in list
        p.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Objects.equals(o1, o2)) {
                    return 0;
                } else if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }); **/
        System.out.println(p);
    }
}
