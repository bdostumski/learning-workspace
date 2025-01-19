import java.util.ArrayList;
import java.util.List;

/*
ArrayList: ArrayList provides us with dynamic arrays in Java.
Though, it may be slower than standard arrays but can be helpful in programs where lots of manipulation in the array is needed.
The size of an ArrayList is increased automatically if the collection grows or shrinks if the objects are removed from the collection.
Java ArrayList allows us to randomly access the list. ArrayList can not be used for primitive types, like int, char, etc.
We will need a wrapper class for such cases. Lets understand the arraylist with the following example:
 */

public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();

        for (int i = 5; i >= 0; i--)
            al.add(i);

        System.out.println(al);

        al.remove(3);
        al.add(5);

        System.out.println(al);

        for (int i = 0; i < al.size(); i++)
            System.out.println(al.get(i));
    }
}
