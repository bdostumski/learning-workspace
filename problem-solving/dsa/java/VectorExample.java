import java.util.List;
import java.util.Vector;

/*
Vector: A vector provides us with dynamic arrays in Java.
Though, it may be slower than standard arrays but can be helpful in programs where lots of manipulation in the array is needed.
This is identical to ArrayList in terms of implementation.
However, the primary difference between a vector and an ArrayList is that a Vector is synchronized and an ArrayList is non-synchronized.
Let’s understand the Vector with an example:
 */

public class VectorExample {

    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();

        for (int i = 0; i <= 5; i++) {
            v.add(i);
        }

        System.out.println(v);
        v.add(0);
        v.remove(1);
        System.out.println(v);
    }
}
